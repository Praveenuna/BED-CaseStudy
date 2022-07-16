var selectedRow = null;

function onFormSubmit() {
  if (validate()) {
    var formData = readFormData();
    if (selectedRow == null) {
      insertNewRecord(formData);
    } else {
      updateRecord(formData);
    }
    resetForm();
  }
}

function readFormData() {
  var formData = {};
  formData["SerialNo"] = document.getElementById("SerialNo").value;
  console.log(formData["SerialNo"]);
  formData["StudentName"] = document.getElementById("StudentName").value;
  formData["Subject"] = document.getElementById("Subject").value;
  formData["AssignmentCategory"] =
    document.getElementById("AssignmentCategory").value;
  formData["DateOfSubmission"] =
    document.getElementById("DateOfSubmission").value;
  formData["Points"] = document.getElementById("Points").value;
  return formData;
}

function insertNewRecord(data) {
  console.log("DATA" + JSON.stringify(data));
  var table = document
    .getElementById("employeeList")
    .getElementsByTagName("tbody")[0];
  console.log(table);

  var newRow = table.insertRow(table.length);
  cell1 = newRow.insertCell(0);
  cell1.innerHTML = data.SerialNo;
  cell2 = newRow.insertCell(1);
  cell2.innerHTML = data.StudentName;
  cell3 = newRow.insertCell(2);
  cell3.innerHTML = data.Subject;
  cell4 = newRow.insertCell(3);
  cell4.innerHTML = data.AssignmentCategory;
  cell5 = newRow.insertCell(4);
  cell5.innerHTML = data.DateOfSubmission;
  cell6 = newRow.insertCell(5);
  cell6.innerHTML = data.Points;
  cell6 = newRow.insertCell(6);
  cell6.innerHTML = `<a onClick="onEdit(this)">Edit</a>
                       <a onClick="onDelete(this)">Delete</a>`;
}

function resetForm() {
  document.getElementById("SerialNo").value = "";
  document.getElementById("StudentName").value = "";
  document.getElementById("Subject").value = "";
  document.getElementById("AssignmentCategory").value = "";
  document.getElementById("DateOfSubmission").value = "";
  document.getElementById("Points").value = "";
  selectedRow = null;
}

function onEdit(td) {
  selectedRow = td.parentElement.parentElement;
  document.getElementById("SerialNo").value = selectedRow.cells[0].innerHTML;
  document.getElementById("StudentName").value = selectedRow.cells[1].innerHTML;
  document.getElementById("Subject").value = selectedRow.cells[2].innerHTML;
  document.getElementById("AssignmentCategory").value =
    selectedRow.cells[3].innerHTML;
  document.getElementById("DateOfSubmission").value =
    selectedRow.cells[4].innerHTML;
  document.getElementById("Points").value = selectedRow.cells[5].innerHTML;
}
function updateRecord(formData) {
  selectedRow.cells[0].innerHTML = formData.SerialNo;
  selectedRow.cells[1].innerHTML = formData.StudentName;
  selectedRow.cells[2].innerHTML = formData.Subject;
  selectedRow.cells[3].innerHTML = formData.AssignmentCategory;
  selectedRow.cells[4].innerHTML = formData.DateOfSubmission;
  selectedRow.cells[5].innerHTML = formData.Points;
}

function onDelete(td) {
  if (confirm("Are you sure to delete this record ?")) {
    row = td.parentElement.parentElement;
    document.getElementById("employeeList").deleteRow(row.rowIndex);
    resetForm();
  }
}
function validate() {
  isValid = true;
  if (document.getElementById("SerialNo").value == "") {
    isValid = false;
    document.getElementById("SerialNoValidationError").classList.remove("hide");
  } else {
    isValid = true;
    if (
      !document
        .getElementById("SerialNoValidationError")
        .classList.contains("hide")
    ) {
      document.getElementById("SerialNoValidationError").classList.add("hide");
    }
  }
  return isValid;
}