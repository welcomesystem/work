function func(){
      document.getElementById("preview").src="../images/avatar.jpg";
    }
    var avatar = document.getElementById('avatar')
    var preview = document.getElementById('preview')
    function selectAvatar () {
      // .files 拿到的是用户选中的图片的一个数组
      const file = avatar.files[0]
      // 使用fileReader对象可以读取文件信息 ---- 将图片转换为 base64
      const reader = new FileReader()
      // 将选中的文件转换为base64 --- 异步操作
      reader.readAsDataURL(file)
      // 转换完成执行 this.result 就表示 转换成的结果
      reader.onload = function () {
        preview.src = this.result
      }
      console.log(file)
    }