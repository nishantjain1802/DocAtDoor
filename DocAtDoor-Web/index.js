
var HospitalName = document.getElementById("hosp");
var DoctorsAvailable = document.getElementById("doct");
var ContactNum = document.getElementById("contno");
var submit_data = document.getElementById("submitdetails");
var firebaseRef = firebase.database().ref();
function submit_details()
{
	firebaseRef = firebase.database().ref('hospitalName/'+ hospitalName.value).set({HospitalName: hosp.value,DoctorsAvailable: doct.value,ContactNum: contno.value});	
}