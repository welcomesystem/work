
function setCompleted(){//将个人完成状态设置成“已完成”
    var uncompletedObj = document.getElementById("uncompleted");
    uncompletedObj.style.display = "none";
}

function setUncompleted(){//将个人完成状态设置成“未完成”
    var completedObj = document.getElementById("completed");
    completedObj.style.display = "none";
}