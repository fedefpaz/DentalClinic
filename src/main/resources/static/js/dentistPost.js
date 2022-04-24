window.addEventListener('load', function () {

const form = document.querySelector('#add_new_dentist');

    form.addEventListener('submit', function (event) {
    event.preventDefault();

        let formData = {
            surname :  document.querySelector("#surname").value,
            name : document.querySelector("#name").value,
            license: document.querySelector("#enrollment").value
        };

            const url = '/dentists';
            const settings = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData)
            }
            fetch(url, settings)
                .then(response => response.json())
                .then(data => {
                console.log(data)
                     let successAlert = '<div class="alert alert-success alert-dismissible">' +
                         '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                         '<strong></strong> Dentist Add </div>'
                     resetUploadForm();
                     document.querySelector('#response').innerHTML = successAlert;
                     document.querySelector('#response').style.display = "block";

            })
            .catch(error => {
                  let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error, try again</strong> </div>'

                   document.querySelector('#response').innerHTML = errorAlert;
                   document.querySelector('#response').style.display = "block";
                   resetUploadForm();
                   console.log(error)})
    });

    function resetUploadForm(){
        document.querySelector("#name").value = "";
        document.querySelector("#surname").value = "";
        document.querySelector("#enrollment").value = "";
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/dentist.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});