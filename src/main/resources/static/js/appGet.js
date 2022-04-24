window.addEventListener('load', function () {

    (function(){
      const url = '/appointments/findAll';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
         for(app of data){

          let table = document.getElementById("appTable");
          let appRow =table.insertRow();
          let tr_id = 'tr_' + app.id;
          appRow.id = tr_id;


           let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + app.id + '\"' +
                                      ' type="button" onclick="deleteBy('+app.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

          let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + app.id + '\"' +
                                      ' type="button" onclick="findBy('+app.id+')" class="btn btn-info btn_id">' +
                                      app.id +
                                      '</button>';

         appRow.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_register\">' + app.time + '</td>' +
                              '<td class=\"td_register\">' + app.date + '</td>' +
                              '<td class=\"td_first_name\">' + app.patient.id + '</td>' +
                              '<td class=\"td_last_name\">' + app.dentist.id + '</td>' +
                              '<td>' + deleteButton + '</td>';

        };

})
.catch(error => {            console.log(error)})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/appointment.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})