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
  formData["AssignmentCategory"] = document.getElementById("AssignmentCategory").value;
  console.log(formData["AssignmentCategory"]);
  formData["Weight"] = document.getElementById("Weight").value;
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
  cell1.innerHTML = data.AssignmentCategory;
  cell2 = newRow.insertCell(1);
  cell2.innerHTML = data.Weight;
  cell3 = newRow.insertCell(2);
  cell3.innerHTML = `<a onClick="onDelete(this)">Delete</a>`;
}

function resetForm() {
  document.getElementById("AssignmentCategory").value = "";
  document.getElementById("Weight").value = "";
  selectedRow = null;
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
  if (document.getElementById("AssignmentCategory").value == "") {
    isValid = false;
    document.getElementById("AssignmentCategoryValidationError").classList.remove("hide");
  } else {
    isValid = true;
    if (
      !document
        .getElementById("AssignmentCategoryValidationError")
        .classList.contains("hide")
    ) {
      document.getElementById("AssignmentCategoryValidationError").classList.add("hide");
    }
  }
  return isValid;
}