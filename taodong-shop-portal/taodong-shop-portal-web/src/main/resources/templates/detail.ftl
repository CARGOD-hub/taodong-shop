<#include "base/head.ftl"/>
<div class="layui-container" style="padding: 40px 0;">
    <div class="layui-row">
        <div class="layui-col-md6">
            <img src="${(product.mainImage)!'../res/static/img/hot_sale1.jpg'}" style="width: 100%; border-radius: 8px;" onerror="this.src='../res/static/img/hot_sale1.jpg'">
        </div>
        <div class="layui-col-md6" style="padding-left: 40px;">
            <h1 style="font-size: 24px; color: #333; margin-bottom: 15px;">${(product.name)!'商品名称'}</h1>
            <p style="font-size: 14px; color: #666; margin-bottom: 20px;">${(product.subtitle)!'商品描述'}</p>
            <div style="background: #fff5f5; padding: 20px; border-radius: 8px; margin-bottom: 30px;">
                <span style="font-size: 16px; color: #999;">价格：</span>
                <span style="font-size: 32px; color: #ff4d4f; font-weight: bold;">￥${(product.price)!0}</span>
            </div>
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-lg layui-btn-danger" style="width: 160px;" onclick="alert('立即购买功能正在开发中')">立即购买</button>
                <form action="/addToCart" method="post" style="display: inline-block;">
                    <input type="hidden" name="productId" value="${(product.id)!1}">
                    <input type="hidden" name="quantity" value="1">
                    <button type="submit" class="layui-btn layui-btn-lg layui-btn-normal" style="width: 160px;">加入购物车</button>
                </form>
            </div>
        </div>
    </div>
    <div class="layui-row" style="margin-top: 50px;">
        <div class="layui-col-md12">
            <div class="hot-sell">
                <p class="house-title">商品详情</p>
                <div style="padding: 20px; background: #fff; border-radius: 8px;">
                    <p style="font-size: 16px; color: #666; line-height: 2;">${(product.detail)!'暂无商品详情'}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-row" style="margin-top: 40px;">
        <div class="layui-col-md12">
            <div class="hot-sell">
                <p class="house-title">猜你喜欢</p>
                <div class="layui-row layui-col-space20">
                    <a href="detail.html?id=1" class="layui-col-xs3 text">
                        <div><img src="../res/static/img/hot_sale1.jpg"></div>
                        <p>烟台红富士苹果</p>
                        <p class="price">￥36.80</p>
                    </a>
                    <a href="detail.html?id=2" class="layui-col-xs3 text">
                        <div><img src="../res/static/img/hot_sale2.jpg"></div>
                        <p>赣州脐橙</p>
                        <p class="price">￥38.90</p>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "base/bottom.ftl"/>
