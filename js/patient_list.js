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
                    alert("clicked")
                });
                tableAppointment.appendChild(tablerow)

            })
        }
    }
    xhr.send()
}

        //         var temp = "";
//         var tbl = document.getElementById('employee_table');
//         var tbdy = document.createElement('tbody');
//         data.forEach((u) => {

//         var linktag = document.createElement('a')

//             var tr = document.createElement('tr');
//             var td1 = document.createElement('td');
//             var txt1 = document.createTextNode(u.patientname);
//             td1.appendChild(txt1);
//             tr.appendChild(td1)
//             var td2 = document.createElement('td');
//             var txt2 = document.createTextNode(u.patientname);
//             td2.appendChild(txt2);
//             tr.appendChild(td2);
//             var td3 = document.createElement('td');
//             var txt3 = document.createTextNode(u.patientphonenumber);
//             td3.appendChild(txt3);
//             tr.appendChild(td3)
//             linktag.appendChild(tr)
//             tbdy.appendChild(linktag);
//             tbl.appendChild(tbdy);
//         })
//     }
// }
// xhr.send()


