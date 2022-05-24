
// 获取元素
var input = document.querySelector('#vcode');
var btn = document.querySelector('#sub');
var div = document.querySelector('#vdiv');

// 搞一个字符库
var characters = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
var str; // str用来储存验证码的文本

// 生成一个在[l,r]范围内的随机整数的函数
function getRandom(l, r) {
    return parseInt(l + Math.random() * (r - l + 1));
}

// 设置文本不可选中
div.addEventListener('selectstart', function (e) {
    e.preventDefault();
})

// 生成验证码的函数
function run() {

    // 先重置str
    str = '';

    // 删除掉div中的所有子节点
    while (div.hasChildNodes()) {
        div.removeChild(div.firstChild);
    }

    // 生成由四个字符组成的验证码
    for (var i = 0; i < 4; i++) {

        // 创建一个span对象
        var span = document.createElement('span');

        // 设置文本（从字库中随机抽取一个字符）
        span.innerHTML = characters[getRandom(0, characters.length - 1)];

        // 设置一些随机的样式
        span.style.display = 'inline-block';
        span.style.fontSize = getRandom(16, 32) + 'px';
        span.style.color = 'rgb(' + getRandom(0, 200) + ',' + getRandom(0, 200) + ',' + getRandom(0, 200) + ')';
        span.style.transform = 'translate(' + getRandom(-5, 5) + 'px, ' + getRandom(-5, 5) + 'px) rotate(' + getRandom(-20, 20) + 'deg)';
        str += span.innerHTML; // str记录字符
        div.appendChild(span); // 将span添加到div中
    }
}


run(); // 每次打开/刷新页面时先调用一次
div.addEventListener('click', run); // 每次点击验证码的时候调用一次

// 提交按钮点击事件
function check() {
    if (input.value.toLowerCase() == str.toLowerCase()) {
        alert('验证成功');
    } else {
        alert('验证失败');
        return ;
    }
    run();
    input.value = '';
    frm.submit();
}
