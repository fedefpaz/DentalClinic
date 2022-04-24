window.addEventListener('load', function () {

    const form = document.querySelector('#update_patient_form');
    form.addEventListener('submit', function (event) {
                event.preventDefault();

                let patientId = document.querySelector('#patientId').value;

                const formData = {
                                   id: document.querySelector('#patientId').value,
                                   name: document.querySelector('#nombre').value,
                                   surname: document.querySelector('#apellido').value,
                                   dni: document.querySelector('#dni').value,
                                   dischargeDate: document.querySelector('#initDate').value,
                                   addressId: {
                                   street: street,
                                   number: number,
                                   city: city,
                                   province: province
                                   }
                                   };
            }
                    const url = '/patients/update';
                            const settings = {
                                method: 'PUT',
                                headers: {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(formData)
                            }
                              fetch(url,settings)
                              .then(response => response.json())
                              .then((result) => {
                                  console.log(result);
                                })
                                .catch((error) => {
                                  console.error("error", error);
                                });

                                location.reload();
                                })
             })

             function findById(id) {
                       const url = '/patients/findById/'+id;
                       const settings = {
                           method: 'GET'
                       }
                       fetch(url,settings)
                                 .then(response => response.json())
                                 .then(data => {
                                     let patient = data;
                                     document.querySelector('#patientId').value = patient.id;
                                     document.querySelector('#nombre').value = patient.name;
                                     document.querySelector('#apellido').value = patient.surname;
                                     document.querySelector('#dni').value = patient.dni;
                                     document.querySelector('#initDate').value = patient.dischargeDate;

                                     document.querySelector('#street').value = patient.addressId.street;
                                     document.querySelector('#number').value = patient.addressId.number;
                                     document.querySelector('#city').value = patient.addressId.city;
                                     document.querySelector('#province').value = patient.addressId.province;

                                 }).catch(error => {
                                 document.querySelector('#div_patient_updating');

                                     console.log(error)
                                 })
                             }