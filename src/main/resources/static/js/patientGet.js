window.addEventListener('load', function () {

    (function(){
      const url = '/patients/findAll';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
         for(patient of data){

          let table = document.getElementById("patientTable");
          let patientRow =table.insertRow();
          let tr_id = 'tr_' + patient.id;
          patientRow.id = tr_id;


           let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + patient.id + '\"' +
                                      ' type="button" onclick="deleteBy('+patient.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

          let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + patient.id + '\"' +
                                      ' type="button" class="btn btn-info btn_id">' +
                                      patient.id +
                                      '</button>';


         patientRow.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_first_name\">' + patient.name + '</td>' +
                              '<td class=\"td_last_name\">' + patient.surname + '</td>' +
                              '<td class=\"td_register\">' + patient.dni + '</td>' +
                              '<td class=\"td_register\">' + patient.dischargeDate + '</td>' +
                              '<td class=\"td_register\">' + patient.addressId.street + '</td>' +
                              '<td class=\"td_register\">' + patient.addressId.number + '</td>' +
                              '<td class=\"td_register\">' + patient.addressId.city + '</td>' +
                              '<td class=\"td_register\">' + patient.addressId.province + '</td>' +
                              '<td>' + deleteButton + '</td>';

        };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/patient.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})