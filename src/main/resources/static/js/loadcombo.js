

function loadcombo(params, callback) {
    $.getJSON(params.url, function (data) {
        $dropdown = $(params.selector);
        $('<option/>').val('').html(params.heading)
                .appendTo($dropdown);
        $.each(data, function (index, row) {
            $('<option/>').val(row[params.data[0]]).html(row[params.data[1]])
                    .appendTo($dropdown);
        })
        if (callback !== undefined) {
            callback();

        }
    })

}

function chartcombo(params) {
    $.getJSON(params.json, function (data) {
        $(params.status).find('input[value]').val(data.length);

    })
    return false;
}

var loadFile = function (event) {
    var image = document.getElementById('output');
    image.src = URL.createObjectURL(event.target.files[0]);
};

