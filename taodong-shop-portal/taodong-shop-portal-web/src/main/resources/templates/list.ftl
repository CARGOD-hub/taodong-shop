<#include "base/head.ftl"/>
<div class="layui-container" style="padding: 20px 0;">
    <div class="hot-sell">
        <p class="house-title">全部商品</p>
        <div class="layui-row layui-col-space20">
            <#if productList?? && (productList?size > 0)>
                <#list productList as product>
                    <a href="detail.html?id=${product.id}" class="layui-col-xs3 text">
                        <div><img src="${product.mainImage!}" style="width: 100%; height: 200px; object-fit: cover;" onerror="this.src='../res/static/img/hot_sale1.jpg'"></div>
                        <p>${product.name!"商品名称"}</p>
                        <p class="price">￥${product.price!0}</p>
                    </a>
                </#list>
            <#else>
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
            </#if>
        </div>
    </div>
</div>
<#include "base/bottom.ftl"/>
