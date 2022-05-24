 //公告管理（添加）
 function anno_add(){
    document.getElementById('frm_Announce').setAttribute('hidden',true);
    document.getElementById('add_Announce').removeAttribute('hidden')
}
//公告管理（查找）
function anno_search(){
    

}
//公告管理（保存）
function anno_save(){
    document.getElementById('add_Announce').setAttribute('hidden',true);
    document.getElementById('frm_Announce').removeAttribute('hidden')
    //缺少提交表单
}
//公告管理（取消）
function anno_cancel(){
    document.getElementById('add_Announce').setAttribute('hidden',true);
    document.getElementById('frm_Announce').removeAttribute('hidden')
}
//切换到公告管理
function show_anno(){
    document.getElementById('frm_Announce').removeAttribute('hidden');
    document.getElementById('frm_AddStudent').setAttribute('hidden',true);
    document.getElementById('frm_AddTeacher').setAttribute('hidden',true);                
}
//切换到添加学生
function show_addstu(){
    document.getElementById('frm_AddStudent').removeAttribute('hidden');
    document.getElementById('frm_Announce').setAttribute('hidden',true);
    document.getElementById('frm_AddTeacher').setAttribute('hidden',true);
}
//切换到添加教职工
function show_addtea(){
    document.getElementById('frm_AddTeacher').removeAttribute('hidden');
    document.getElementById('frm_AddStudent').setAttribute('hidden',true);
    document.getElementById('frm_Announce').setAttribute('hidden',true);
}