var xhr = new XMLHttpRequest()

// Open a new connection, using the GET xhr on the URL endpoint 
xhr.open('GET', 'http://localhost:8181/api/patient_list/10', true)
// xhr.setRequestHeader("Content-Type", "application/json");
// req.setRequestHeader( 'Accept', 'application/json' );
xhr.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwMTYxMzU3NTI4OSIsImlhdCI6MTU3Mzk4ODI0MCwiZXhwIjoxNTczOTg5MTQwfQ.zZ1wgl2qDNyHV9g14oToqoTrkvSivKHxe6fvZcv2ynVUUGUfEn-wu27EjNsd2JY-k-n-T4Wk3FM2lFdbXLdzIw")
xhr.onload = function () {
    var data = JSON.parse(this.response)

   console.log(data)
   if(data.length > 0){
    var temp = "";
    var tbl = document.getElementById('employee_table');
    var tbdy = document.createElement('tbody');
    data.forEach((u)=>{
        var tr = document.createElement('tr');
            var td1 = document.createElement('td');
                var txt1 = document.createTextNode(u.name);
                td1.appendChild(txt1);
                tr.appendChild(td1)
                var td2 = document.createElement('td');
                var txt2 = document.createTextNode(u.species);
                td2.appendChild(txt2);
                tr.appendChild(td2);
                var td3 = document.createElement('td');
                var txt3 = document.createTextNode(u.foods.likes);
                td3.appendChild(txt3);
                tr.appendChild(td3)

                tbdy.appendChild(tr);
                tbl.appendChild(tbdy);
        })  
    }
}
xhr.send()


