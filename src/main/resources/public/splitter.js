$(document).ready(function() {
    var splitTextFunction = function(){
        var text = $('#input-text').val();
        var lettersPerLine = parseInt($('#letters-per-line').val());

        splitIntoLines(text, lettersPerLine);
    };

    $('#SubmitButton').click(splitTextFunction);
    //splitTextFunction();
});

function splitIntoLines(text, lettersPerLine){
    var protocol = location.protocol;
    var slashes = protocol.concat("//");
    var host = slashes.concat(window.location.host);
    var lineSplitterServiceLocation = host + "/split";
    $.ajax({
            url: lineSplitterServiceLocation,
            data: {'text':text, 'lettersPerLine':lettersPerLine}
        }).then(function(data) {
           $('#formatted-text').text(data.content);
        });
}