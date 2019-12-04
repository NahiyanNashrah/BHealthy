var request = new XMLHttpRequest()

// Open a new connection, using the GET request on the URL endpoint
request.open('GET', 'http://localhost:3002/api/post/all', true)

request.onload = function () {
    // Begin accessing JSON data here

    var data = JSON.parse(this.response)
    console.log(data)
    data.forEach(prescriptionJSON => {


        var app = document.getElementById('post');
        var head1 = document.createElement('h3');
        head1.style.color = "#000000"
        
        head1.setAttribute('href','www.google.com')
        head1.textContent = prescriptionJSON.title;
        var p1 = document.createElement('p')
        app.appendChild(head1);
        p1.textContent =   prescriptionJSON.body;
        app.appendChild(p1);
        var br1 = document.createElement('br')
        app.appendChild(br1)
        var btninfo = document.createElement('button')
        btninfo.setAttribute('class','btn btn-info')
        btninfo.textContent = "See Details"
        app.appendChild(btninfo)
        // app er vitor holder
        var holder = document.createElement('div')
        holder.style.marginTop = "10px"
        app.appendChild(holder)
        var rate = document.createElement('span')
        rate.textContent = "Rating : " + prescriptionJSON.rating;
        var ratestar = document.createElement('div')
        ratestar.setAttribute('class', 'pull-right')
        rate.appendChild(ratestar)
        var rateDetailes = document.createElement('div')
        rateDetailes.setAttribute('class', 'rate')
        ratestar.appendChild(rateDetailes)

        var x5 = document.createElement("input");
        x5.setAttribute("type", "radio");
        x5.setAttribute("value", "5")
        rateDetailes.appendChild(x5)
        var star5 = document.createElement("label")
        star5.htmlFor = x5;
        rateDetailes.appendChild(star5)
        star5.onclick = function () { x5.checked = true; }


        var x4 = document.createElement("input");
        x4.setAttribute("type", "radio");
        x4.setAttribute("value", "4")
        rateDetailes.appendChild(x4)
        var star4 = document.createElement("label")
        star4.htmlFor = x4;
        rateDetailes.appendChild(star4)
        star4.onclick = function () { x4.checked = true; }



        var x3 = document.createElement("input");
        x3.setAttribute("type", "radio");
        x3.setAttribute("value", "3")
        rateDetailes.appendChild(x3)
        var star3 = document.createElement("label")
        star3.htmlFor = x3;
        rateDetailes.appendChild(star3)
        star3.onclick = function () { x3.checked = true; }

        var x2 = document.createElement("input");
        x2.setAttribute("type", "radio");
        x2.setAttribute("value", "2")
        rateDetailes.appendChild(x2)
        var star2 = document.createElement("label")
        star2.htmlFor = x2;
        rateDetailes.appendChild(star2)
        star2.onclick = function () { x2.checked = true; }


        var x1 = document.createElement("input");
        x1.setAttribute("type", "radio");
        x1.setAttribute("value", "1")
        rateDetailes.appendChild(x1)
        var star1 = document.createElement("label")
        star1.htmlFor = x1;
        rateDetailes.appendChild(star1)
        star1.onclick = function () { x1.checked = true; }


        var button = document.createElement('button')
        button.textContent = "Rate Now"
        button.setAttribute('class','btn btn-primary')
        ratestar.appendChild(button)

        btninfo.onclick = function(){
            window.location.replace('./singlePost.html?id='+prescriptionJSON._id)
        }

        button.onclick = function () {
            if(window.localStorage.getItem('token') == null){
                alert("Please Login First")
                window.location.replace('./home.html')
            }
            else{
            var ratevalue;
            if (x5.checked == true) {
                // alert("Done" + x5.value)
                ratevalue = x5.value;
                console.log(ratevalue)
            }
            else if (x4.checked) {
                // alert("Done" + x4.value)
                ratevalue = x4.value;
                console.log(ratevalue)
            }
            else if (x3.checked == true) {
                // alert("Done" + x3.value)
                ratevalue = x3.value;
                console.log(ratevalue)
            }
            else if (x2.checked == true) {

                ratevalue = x2.value;
                console.log(ratevalue)
            }
            else if (x1.checked == true) {

                ratevalue = x1.value;
                console.log(ratevalue)
            }
            ratevalue = parseFloat(ratevalue)
            console.log(ratevalue)
            var prerating = prescriptionJSON.rating;
            prerating = parseFloat(prerating)
            var precnt = prescriptionJSON.cnt;
            precnt = parseFloat(precnt)
            console.log(precnt)
            var avg = prerating*precnt;
            console.log(avg)
            var newrating = avg + ratevalue
            newrating = newrating/(precnt+1.00) 
            var request1 = new XMLHttpRequest()
            var token = window.localStorage.getItem('token');
            var token_json = JSON.parse(token);
            var frating = String(newrating)
            // Open a new connection, using the GET request on the URL endpoint
            request1.open('POST', 'http://localhost:3002/api/post/rating', true)
            request1.setRequestHeader("Content-Type", "application/json");
            request1.setRequestHeader("Authorization", "Bearer " + token_json.token);
            var data1 = JSON.stringify({ "rating": frating, "id": prescriptionJSON._id });
            console.log(data1)
            request1.onload = function () {
                if (this.status == 200){
                    window.location.replace('./home.html')
                }
            }
            request1.send(data1)
        }
    }
        var hrr = document.createElement('hr')

        app.appendChild(rate)
        app.appendChild(hrr)

    })

}

// Send request
request.send()





{/* <div class="about">
<div class="container">
    <div class="row row-lg-eq-height">

        <!-- About Content -->
        <div class="col-lg-7">
            <div class="about_content">
                <div class="section_title">
                    <h2>A great medical team to help your needs</h2>
                </div>
                <div class="about_text">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ante leo, finibus
                        quis est ut, tempor tincidunt ipsum. Nam consequat semper sollicitudin. Aliquam nec
                        dapibus massa. Pellen tesque in luctus ex. Praesent luctus erat sit amet tortor
                        aliquam bibendum. Nulla ut molestie augue, scelerisque consectetur quam. Dolor sit
                        amet, consectetur adipiscing elit. Cura bitur ante leo, finibus quis est ut, tempor
                        tincidunt ipsum. Nam consequat semper sollicitudin. Aliquam nec dapibus massa.
                        Pellentesque in luctus ex.</p>
                </div>
                <div class="button about_button">
                    <a href="#">read more</a>
                </div>
            </div>
        </div>

        <!-- About Image -->
        <div class="col-lg-5">
            <div class="about_image"><img src="images/about.png" alt=""></div>
        </div>
    </div>
</div>
</div> */}

var request = new XMLHttpRequest()

// Open a new connection, using the GET request on the URL endpoint
request.open('GET', 'http://localhost:8181/api/get-all-doctor', true)
//request.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwMTk3MTQyOTU5MiIsImlhdCI6MTU3MzMyNzE0MSwiZXhwIjoxNTczMzI4MDQxfQ.6O0CttauYGXElg1KW0J1j-CJR30Xn_FMDCea3qzDQQr4wVme3BklUI_gAvuL3Pb3hP6BvVJS-BOpcZ2A0b94rw");

request.onload = function () {
    // Begin accessing JSON data here

    var data = JSON.parse(this.response)
    console.log(data)
    data.forEach(doctorJSON => {

        const app = document.getElementById('doctorList')
        const row = document.createElement('div')
        row.setAttribute('class', 'row-lg-eq-height')
        row.appendChild(app)
        const info = document.createElement('div')
        info.setAttribute('class', 'col-lg-7')
        info.appendChild(row)

        const info_content = document.createElement('div')
        info_content.setAttribute('class', 'info_content')
        var doc_name = document.createElement('div')
        doc_name.setAttribute('class','doc_name')
        doc_name.textContent = doctorJSON.name;
        info_content.appendChild(doc_name)

        var doc_dept = document.createElement('div')
        doc_dept.setAttribute('class','doc_dept')
        doc_dept.textContent = doctorJSON.department;
        info_content.appendChild(doc_dept)

        var doc_degree = document.createElement('div')
        doc_degree.setAttribute('class','doc_degree')
        doc_degree.textContent = doctorJSON.degree;
        info_content.appendChild(doc_degree)

        var doc_visiting = document.createElement('div')
        doc_visiting.setAttribute('class','doc_visiting')
        doc_visiting.textContent = doctorJSON.visiting_hour;
        info_content.appendChild(doc_visiting)

        var doc_location = document.createElement('div')
        doc_location.setAttribute('class','doc_location')
        doc_location.textContent = doctorJSON.location;
        info_content.appendChild(doc_location)

        var doc_fees = document.createElement('div')
        doc_fees.setAttribute('class','doc_fees')
        doc_fees.textContent = doctorJSON.fees;
        info_content.appendChild(doc_fees)

        var btninfo = document.createElement('button')
        btninfo.setAttribute('class','btn btn-info')
        btninfo.textContent = "See Details"
        info_content.appendChild(btninfo)
        info.appendChild(info_content)

        const info_image = document.createElement('div')
        info.setAttribute('class', 'col-lg-5')
        info.appendChild(row)

        const doc_Image = document.createElement('div')
        doc_Image.setAttribute('class', 'doct_image')

        const img = document.createElement('img')
        img.src = doctorJSON.image;
        doc_Image.appendChild(img)

        row.appendChild(doc_Image);

        app.appendChild(row)
        var hrr = document.createElement('hr')
        app.appendChild(hrr)

    })
}

// Send request
request.send()





