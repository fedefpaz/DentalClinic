window.addEventListener('load', function () {

    const form= document.querySelector('#add_new_app');

    form.addEventListener('submit', function (event) {
        event.preventDefault();
        const patient_id = document.querySelector('#idpatient').value
        const dentist_id = document.querySelector('#iddentist').value

        const formData = {
            time: document.querySelector('#time').value,
            date: document.querySelector('#date').value,
            patient:{
                id: patient_id
            } ,
            dentist: {
                id: dentist_id
            }
        };

        const url = '/appointments/create';
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
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Appointment Add </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {
            console.log(error)
                  let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error, try again</strong> </div>'

                   document.querySelector('#response').innerHTML = errorAlert;
                   document.querySelector('#response').style.display = "block";

                   resetUploadForm();})
    });

    function resetUploadForm(){
        document.querySelector('#idpatient').value = "";
        document.querySelector('#iddentist').value = "";
        document.querySelector('#date').value = "";
        document.querySelector('#time').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/appointment.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});