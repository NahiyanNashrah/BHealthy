
var datauser = JSON.parse(window.localStorage.getItem('user'));
if(datauser !== null){
var roleuser;
datauser.authorities.forEach(doctorJSON => {
    roleuser = doctorJSON.authority;
});
if (roleuser == "ROLE_DOCTOR") {
    var drop = document.getElementById('dropdownconfig');
    
    var dashboard = document.createElement('li');
    var ahrefd = document.createElement('a');
    ahrefd.setAttribute('href', 'doctordashboard.html');
    ahrefd.textContent = "Doctor Dashboard"
    dashboard.appendChild(ahrefd);
    drop.appendChild(dashboard);

    var track = document.createElement('li');
    var ahref = document.createElement('a');
    ahref.setAttribute('href', 'patient_list.html');
    ahref.textContent = "Track Patient List"
    track.appendChild(ahref);
    drop.appendChild(track);

    

    var logout = document.createElement('li');
    var ahreflogout = document.createElement('a');
    ahreflogout.setAttribute('href', 'javascript:logout()');
    ahreflogout.textContent = "Logout"
    logout.appendChild(ahreflogout);
    drop.appendChild(logout);



}
else{
    var drop = document.getElementById('dropdownconfig');
    
    var profile = document.createElement('li');
    var ahrefp = document.createElement('a');
    ahrefp.setAttribute('href', 'patient_profile.html');
    ahrefp.textContent = "My Profile"
    profile.appendChild(ahrefp);

    var prescription = document.createElement('li');
    var ahref = document.createElement('a');
    ahref.setAttribute('href', 'my_prescription.html');
    ahref.textContent = "My Prescription"
    prescription.appendChild(ahref);

    var addprescription = document.createElement('li');
    var addahref = document.createElement('a');
    addahref.setAttribute('href', 'addprescription.html');
    addahref.textContent = "Add Prescription"
    addprescription.appendChild(addahref);

    var appointment = document.createElement('li');
    var ahrefapp = document.createElement('a');
    ahrefapp.setAttribute('href', 'myappointment.html');
    ahrefapp.textContent = "Track My Appointment"
    appointment.appendChild(ahrefapp);

    var logout = document.createElement('li');
    var ahreflogout = document.createElement('a');
    ahreflogout.setAttribute('href', 'javascript:logout()');
    ahreflogout.textContent = "Logout"
    logout.appendChild(ahreflogout);



    drop.appendChild(profile)
    drop.appendChild(prescription)
    drop.appendChild(addprescription)
    drop.appendChild(appointment)
    drop.appendChild(logout)
}




}