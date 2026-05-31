<#include "base/head.ftl"/>
<div class="layui-container" style="padding: 40px 0;">
    <div class="layui-card">
        <div class="layui-card-header">
            <h2>购物车</h2>
        </div>
        <div class="layui-card-body">
            <#if cart?? && (cart?size > 0)>
                <table class="layui-table">
                    <thead>
                        <tr>
                            <th>商品图片</th>
                            <th>商品名称</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>小计</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list cart as item>
                            <tr>
                                <td><img src="${(item.image)!'../res/static/img/shopnone.png'}" style="width: 80px; height: 80px; object-fit: cover;" onerror="this.src='../res/static/img/hot_sale1.jpg'"></td>
                                <td>${(item.name)!'商品名称'}</td>
                                <td>￥${(item.price)!0}</td>
                                <td>${(item.quantity)!1}</td>
                                <td>￥${((item.price)!0 * (item.quantity)!1)?string("0.00")}</td>
                            </tr>
                        </#list>
                    </tbody>
                </table>
                <div style="text-align: right; margin-top: 20px;">
                    <a href="/order" class="layui-btn layui-btn-lg layui-btn-normal">去结算</a>
                </div>
            <#else>
                <div style="text-align: center; padding: 60px 20px;">
                    <img src="../res/static/img/shopnone.png" style="width: 200px; margin-bottom: 30px;">
                    <h2 style="font-size: 22px; color: #333; margin-bottom: 15px;">购物车空空如也~</h2>
                    <p style="font-size: 14px; color: #999; margin-bottom: 30px;">赶紧去挑选心仪的商品吧！</p>
                    <a href="/" class="layui-btn layui-btn-lg layui-btn-normal">去购物</a>
                </div>
            </#if>
        </div>
    </div>
</div>
<#include "base/bottom.ftl"/>
