<#include "base/head.ftl"/>
<div class="layui-container" style="padding: 40px 0;">
    <div class="layui-card">
        <div class="layui-card-header">
            <h2>订单确认</h2>
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
                <div style="text-align: right; padding: 20px; background: #f9f9f9; border-radius: 8px; margin-top: 20px;">
                    <h3 style="font-size: 24px; color: #333;">总计：<span style="color: #ff4d4f;">￥${total?string("0.00")}</span></h3>
                </div>
                <div style="text-align: right; margin-top: 20px;">
                    <button class="layui-btn layui-btn-lg layui-btn-danger" onclick="alert('支付功能正在开发中')">立即支付</button>
                </div>
            <#else>
                <div style="text-align: center; padding: 60px 20px;">
                    <h2 style="font-size: 22px; color: #333; margin-bottom: 15px;">暂无订单</h2>
                    <p style="font-size: 14px; color: #999; margin-bottom: 30px;">购物车是空的，快去挑选心仪的商品吧！</p>
                    <a href="/" class="layui-btn layui-btn-lg layui-btn-normal">去购物</a>
                </div>
            </#if>
        </div>
    </div>
</div>
<#include "base/bottom.ftl"/>
