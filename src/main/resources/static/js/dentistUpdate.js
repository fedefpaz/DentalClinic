window.addEventListener('load', function () {

    const form = document.querySelector('#update_dentist_form');
    form.addEventListener('submit', function (event) {
        event.preventDefault();
        console.log("hola");

        let dentistId = document.querySelector('#dentist_id').value;

        const formData = {
            id: document.querySelector("#dentist_id").vallue,
            surname :  document.querySelector("#surname").value,
            name : document.querySelector("#name").value,
            license: document.querySelector("#enrollment").value

        };
            
           const settings = {
                     method: "PUT",
                     headers: {
                         "Content-Type": "application/json",
                     },
                     body: JSON.stringify(formData),
                 };

           fetch('/dentists/update', settings)
                     .then((response) => response.json())
                     .then((result) => {
                       console.log(result);
                     })
                     .catch((error) => {
                       console.error("error", error);
                     });

                     location.reload();

               })
            })
                function findBy(id) {
                          const url = '/dentists/findById' +id;
                          const settings = {
                              method: 'GET'
                          }
                          fetch(url,settings)
                          .then(response => response.json())
                          .then(data => {
                              let patient = data;
                              document.querySelector('#dentist_id').value = dentist.id;
                              document.querySelector('#name').value = dentist.name;
                              document.querySelector('#surname').value = dentist.surname;
                              document.querySelector('#enrollment').value = dentist.license;

                          }).catch(error => {
                                    document.querySelector('#div_dentist_updating');

                                        console.log(error);
                                    });



                                }