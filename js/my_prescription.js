function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {
        vars[key] = value;
    });
    return vars;
}

var id = getUrlVars()["id"];

var token;
var data = window.localStorage.getItem('user');
dataJson = JSON.parse(data);
token = dataJson.accessToken;

var request = new XMLHttpRequest()

// Open a new connection, using the GET request on the URL endpoint
request.open('GET', 'http://localhost:8181/api/get-prescrption/'+id, true)
request.setRequestHeader("Authorization", "Bearer "+token);

request.onload = function () {
    // Begin accessing JSON data here

    var data = JSON.parse(this.response)
    console.log(data)
    data.forEach(prescriptionJSON => {

        const app = document.getElementById('prescriptionList')
        const col = document.createElement('div')
        col.setAttribute('class', 'col-lg-3 col-md-6 doct_col')
        app.appendChild(col)
        const fullLink = document.createElement('a')

        var strLink = prescriptionJSON.image
        fullLink.setAttribute("href", strLink)
        fullLink.setAttribute("target","_blank");
        col.appendChild(fullLink)

        const prescription = document.createElement('div')
        prescription.setAttribute('class', 'doct')
        fullLink.appendChild(prescription)

        const prescriptionImage = document.createElement('div')
        prescriptionImage.setAttribute('class', 'doct_image')

        const img = document.createElement('img')
        img.src = prescriptionJSON.image
        prescriptionImage.appendChild(img)

        prescription.appendChild(prescriptionImage);

        const prescription_content = document.createElement('div')
        prescription_content.setAttribute('class', 'doct_content text-center')
        prescription_content.style.backgroundColor = "#ADF5A7"
        prescription.appendChild(prescription_content)

        const prescription_title = document.createElement('div')
        prescription_title.setAttribute('class', 'doct_title')
        prescription_title.textContent = prescriptionJSON.date
        prescription_content.appendChild(prescription_title)

        const prescription_subtitle = document.createElement('div')
        prescription_subtitle.setAttribute('class', 'doct_subtitle')
        prescription_content.appendChild(prescription_subtitle)
        prescription_subtitle.textContent = prescriptionJSON.doctor_name

        const prescription_subtitle1 = document.createElement('div')
        prescription_subtitle1.setAttribute('class', 'doct_subtitle')
        prescription_subtitle1.textContent = prescriptionJSON.department
        prescription_content.appendChild(prescription_subtitle1)


    })
}

// Send request
request.send()


