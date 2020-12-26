function ValidateSize(file) {
    var FileSize = file.files[0].size / 1024 / 1024; // in MB

    var filename = $('#i_file').val();


    if (FileSize > 25) {
        //alert('<br><strong>File size is larger than 25MB</strong>');
        $('#filestatus').html("<div class='alert alert-danger'>");
        $('#filestatus > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                .append("</button>");
        $('#filestatus > .alert-danger')
                .append("<strong>File size is larger than 25MB! </strong>");
        $('#filestatus > .alert-danger')
                .append('</div>');
        //document.getElementById('filestatus').value = 'File size is larger than 25MB';
        //document.getElementById('filestatus').style.color = 'red';
        $(file).val(''); //for clearing with Jquery
        return false;
    } else {

        if (filename.length >= 80) {

            $('#filestatus').html("<div class='alert alert-danger'>");
            $('#filestatus > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                    .append("</button>");
            $('#filestatus > .alert-danger')
                    .append("<strong>Arquivo muito grande, favor anexe um arquivo menor! </strong>");
            $('#filestatus > .alert-danger')
                    .append('</div>');

            //document.getElementById('filestatus').value = 'File name is too large, please rename it';
            //document.getElementById('filestatus').style.color = 'red';
            $(file).val(''); //for clearing with Jquery
            return false;


        } else {


            /* if (!filename.includes(".ppt")) {
             alert('<br><strong>This is not a PowerPoint file</strong>');
             document.getElementById('filestatus').value = 'This is not a PowerPoint file';
             document.getElementById('filestatus').style.color = 'ref';
             $(file).val(''); //for clearing with Jquery
             return false;
             } else {
             document.getElementById('filestatus').value = 'File accepted';
             document.getElementById('filestatus').style.color = 'green';
             return true;
             }*/
            $('#filestatus').html("<div class='alert alert-success'>");
            $('#filestatus > .alert-success').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                    .append("</button>");
            $('#filestatus > .alert-success')
                    .append("<strong>Arquivo " + filename + " aceito! </strong>");
            $('#filestatus > .alert-success')
                    .append('</div>');

            //document.getElementById('filestatus').value = 'File ' + filename + ' accepted';
            //document.getElementById('filestatus').style.color = 'green';

            return true;
        }

    }
}
