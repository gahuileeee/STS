document.addEventListener("DOMContentLoaded", function() {
    var canvas = document.getElementById("drawingCanvas");
    var context = canvas.getContext("2d");

    var drawing = false;

    canvas.addEventListener("mousedown", function(e) {
        drawing = true;
        draw(e.pageX - this.offsetLeft, e.pageY - this.offsetTop, false);
    });

    canvas.addEventListener("mousemove", function(e) {
        if (drawing) {
            draw(e.pageX - this.offsetLeft, e.pageY - this.offsetTop, true);
        }
    });

    canvas.addEventListener("mouseup", function() {
        drawing = false;
        context.beginPath();
    });

    canvas.addEventListener("mouseleave", function() {
        drawing = false;
    });

    function draw(x, y, isDrawing) {
        if (!isDrawing) {
            context.beginPath();
        }
        context.lineWidth = 5;
        context.lineCap = "round";
        context.strokeStyle = "#000000";
        context.lineTo(x, y);
        context.stroke();
    }
});
function submitDrawing() {
    var canvas = document.getElementById('drawingCanvas');
    var drawingData = canvas.toDataURL(); // Canvas 데이터를 Base64로 인코딩

    $.ajax({
        type: 'POST',
        url: 'board01.jsp',
        data: { drawingData: drawingData },
        success: function(response) {
               console.log('Server response:', response);
        },
        error: function(error) {
            console.error('Error submitting drawing:', error);
        }
    });
}