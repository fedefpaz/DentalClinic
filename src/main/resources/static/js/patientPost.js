window.addEventListener('load', function () {
    const form = document.querySelector('#addPatient');

    form.addEventListener('submit', function (event) {
    event.preventDefault();

        const street = document.querySelector('#street').value
        const number = document.querySelector('#number').value
        const city = document.querySelector('#city').value
        const province = document.querySelector('#province').value

        const formData = {
           name: document.querySelector('#name').value,
           surname: document.querySelector('#lastname').value,
           dni: document.querySelector('#dni').value,
           dischargeDate: document.querySelector('#initDate').value,
           addressId: {
           street: street,
           number: number,
           city: city,
           province: province
           }
           };

        const url = '/patients';
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
                     '<strong></strong> Patient Add </div>'
                 resetUploadForm();
                                 console.log("creado");
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
        document.querySelector('#name').value = "";
        document.querySelector('#lastname').value = "";
        document.querySelector('#dni').value = "";
        document.querySelector('#street').value = "";
        document.querySelector('#number').value = "";
        document.querySelector('#initDate').value = "";
        document.querySelector('#city').value = "";
        document.querySelector('#province').value = "";

    }

   (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/patient.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});