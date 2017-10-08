$(document).ready(function() {
    $('#SubmitButton').click(function(){
         var text = $('#test').val();
         var lettersPerLine = parseInt($('#letters-per-line').val());

         splitIntoLines(text, lettersPerLine);
     });

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
           $('.my-formatted-text').text(data.content);
        });
}