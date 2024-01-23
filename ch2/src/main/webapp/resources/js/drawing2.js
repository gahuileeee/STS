document.addEventListener("DOMContentLoaded", function() {
    var canvas = document.getElementById("drawingCanvas");
    var context = canvas.getContext("2d");

    var drawing = false;
    var erasing = false;
    var currentColor = "#000000";
    var lineSize = 5;

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

    document.getElementById("eraserButton").addEventListener("click", function() {
        erasing = !erasing;
        toggleSizeUI(erasing);
        if (erasing) {
            currentColor = "#ffffff";
        } else {
            currentColor = document.getElementById("colorPicker").value;
        }
    });
	
    document.getElementById("penButton").addEventListener("click", function() {
        erasing = false;
        toggleSizeUI(false);
        currentColor = document.getElementById("colorPicker").value;
    });

    document.getElementById("lineSizeRange").addEventListener("input", function() {
        lineSize = parseInt(this.value);
    });

    document.getElementById("colorPicker").addEventListener("input", function() {
        currentColor = this.value;
        erasing = false;
        toggleSizeUI(false);
    });

    function draw(x, y, isDrawing) {
        if (!isDrawing) {
            context.beginPath();
        }
        context.lineWidth = lineSize;
        context.lineCap = "round";
        context.strokeStyle = currentColor;
        context.globalCompositeOperation = erasing ? "destination-out" : "source-over";

        context.lineTo(x, y);
        context.stroke();
    }

   function toggleSizeUI(show) {
    var sizeContainer = document.getElementById("sizeContainer");
    sizeContainer.style.display = "flex";
}
});

function submitDrawing() {
    var canvas = document.getElementById('drawingCanvas');
    var drawingData = canvas.toDataURL("image/png");

    document.getElementById('drawingDataInput').value = drawingData;

    return true;
}