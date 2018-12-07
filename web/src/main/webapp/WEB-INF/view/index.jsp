<div class="layui-header header header-demo" autumn="">
  <div class="layui-main">

    <ul class="layui-nav">
      <li class="layui-nav-item ">
        <a href="/doc/">文档<!-- <span class="layui-badge-dot"></span> --></a>
      </li>
      <li class="layui-nav-item layui-this">
        <a href="/demo/">示例<!--  --></a>
      </li>



      <div id="tree" style="display: none">
        <ul class="wintree" >
          <li class="node">
            <div >
              <div class="extend"><span>+</span></div>
              <input type="checkbox">
              <label>根目录</label>
            </div>
            <ul  >
              <li><input type="checkbox"><label>一级目录</label></li>
              <li><input type="checkbox"><label>一级目录</label></li>
              <%--<li> <div class="extend"><span>+</span></div><input type="checkbox"><label>一级目录</label></li>--%>
              <li class="node">
                <div ><div class="extend"><span>+</span></div><input type="checkbox"><label>一级目录</label></div>
                <ul  >
                  <li><input type="checkbox"><label>二级目录</label></li>
                  <li><input type="checkbox"><label>二级目录</label></li>
                  <li><input type="checkbox"><label>二级目录</label></li>
                  <li class="node">
                    <div ><div class="extend"><span>+</span></div><input type="checkbox"><label>二级目录</label></div>
                    <ul  >
                      <li><input type="checkbox"><label>三级目录</label></li>
                      <li><input type="checkbox"><label>三级目录</label></li>
                      <li><input type="checkbox"><label>三级目录</label></li>
                    </ul>
                  </li>
                </ul>
              </li>
              <li><input type="checkbox"><label>一级目录</label></li>
              <li><input type="checkbox"><label>一级目录</label></li>
            </ul>
          </li>
          <li>
            <input type="checkbox"><label>根目录</label>
          </li>


        </ul>
        <input class="tree_ok" type="button" value="确认" />
        <input class="tree_cancel" type="button" value="取消">
      </div>



      <span class="layui-nav-bar" style="left: 0px; width: 0px; opacity: 0;"></span></ul>
  </div>
</div>