function patientlist() {

    var xhr = new XMLHttpRequest()

    var token;
    var data = window.localStorage.getItem('user');
    dataJson = JSON.parse(data);
    token = dataJson.accessToken;
    console.log(token)
    var date = document.getElementById("datepicker").value;
    var patienttable = document.getElementById('patienttable');


    xhr.open('GET', 'http://localhost:8181/api/patient_list/' + dataJson.phonenumber +'/'+date, true)

    xhr.setRequestHeader("Authorization", "Bearer " + token);
    xhr.onload = function () {
        patienttable.style.display = "block";
        var data = JSON.parse(this.response)

        console.log(data)
        if (data.length > 0) {
            data.forEach((u) => {

                var tableAppointment = document.getElementById('patientList');
                var tablerow = document.createElement('tr');
                tablerow.style.cursor = "pointer"
                var serial = document.createElement('td');
                var serialtxt = document.createTextNode(u.serial);
                serial.appendChild(serialtxt);
                tablerow.appendChild(serial);


                var docname = document.createElement('td');
                var docnametxt = document.createTextNode(u.patientname)
                docname.appendChild(docnametxt);
                tablerow.appendChild(docname);


                var locationD = document.createElement('td');
                var locationtxt = document.createTextNode(u.patientphonenumber);
                locationD.appendChild(locationtxt);
                tablerow.appendChild(locationD);


                tablerow.addEventListener('click', function () {
                    window.localStorage.setItem('prescription',u.patientphonenumber);
                    console.log(window.localStorage.getItem('prescription'));
                    window.location.replace("my_prescription.html");
                });
                tableAppointment.appendChild(tablerow)

            })
        }
    }
    xhr.send()
}
