<#include "base/head.ftl"/>
<div class="layui-container" style="padding: 40px 0;">
    <div class="hot-sell">
        <p class="house-title">AI智能客服</p>
        <div style="padding: 20px; background: #fff; border-radius: 8px; height: 600px; display: flex;">
            <!-- 左侧常见问题 -->
            <div style="width: 260px; border-right: 1px solid #eee; padding: 20px; overflow-y: auto;">
                <h4 style="font-size: 16px; color: #333; margin-bottom: 20px; font-weight: bold;">
                    <i class="layui-icon layui-icon-read" style="color: #ff6b00;"></i> 常见问题
                </h4>
                <div id="quickQuestions">
                    <div class="quick-question" onclick="sendQuickQuestion('你好')">
                        <i class="layui-icon layui-icon-dialogue"></i> 你好
                    </div>
                    <div class="quick-question" onclick="sendQuickQuestion('你们有什么商品？')">
                        <i class="layui-icon layui-icon-cart-simple"></i> 你们有什么商品？
                    </div>
                    <div class="quick-question" onclick="sendQuickQuestion('如何查询订单？')">
                        <i class="layui-icon layui-icon-list"></i> 如何查询订单？
                    </div>
                    <div class="quick-question" onclick="sendQuickQuestion('如何申请退款？')">
                        <i class="layui-icon layui-icon-refresh"></i> 如何申请退款？
                    </div>
                    <div class="quick-question" onclick="sendQuickQuestion('物流需要多久？')">
                        <i class="layui-icon layui-icon-car"></i> 物流需要多久？
                    </div>
                </div>
                <div style="margin-top: 30px; padding-top: 20px; border-top: 1px solid #eee;">
                    <h4 style="font-size: 14px; color: #333; margin-bottom: 15px; font-weight: bold;">
                        <i class="layui-icon layui-icon-cellphone" style="color: #009688;"></i> 其他联系方式
                    </h4>
                    <p style="color: #666; font-size: 14px; margin-bottom: 8px;">📞 客服电话：400-123-4567</p>
                    <p style="color: #999; font-size: 12px;">工作时间：9:00 - 21:00</p>
                </div>
            </div>
            
            <!-- 右侧聊天区域 -->
            <div style="flex: 1; display: flex; flex-direction: column; padding: 20px;">
                <!-- 聊天头部 -->
                <div style="padding: 15px 20px; background: linear-gradient(135deg, #ff6b00 0%, #ff8c00 100%); border-radius: 8px 8px 0 0; color: white; display: flex; align-items: center;">
                    <div style="width: 50px; height: 50px; background: white; border-radius: 50%; display: flex; align-items: center; justify-content: center; margin-right: 15px;">
                        <i class="layui-icon layui-icon-face-smile" style="font-size: 30px; color: #ff6b00;"></i>
                    </div>
                    <div>
                        <h3 style="font-size: 18px; margin: 0;">小淘</h3>
                        <p style="font-size: 12px; margin: 5px 0 0 0; opacity: 0.9;">淘东智能客服 · 在线</p>
                    </div>
                    <div style="margin-left: auto;">
                        <button class="layui-btn layui-btn-sm layui-btn-normal" onclick="clearChat()" style="background: rgba(255,255,255,0.2); border: none;">
                            <i class="layui-icon layui-icon-delete"></i> 清空聊天
                        </button>
                    </div>
                </div>
                
                <!-- 聊天消息区域 -->
                <div id="chatArea" style="flex: 1; overflow-y: auto; padding: 20px; background: #f5f5f5; min-height: 350px;">
                    <div class="message ai-message">
                        <div class="message-avatar">
                            <i class="layui-icon layui-icon-face-smile" style="font-size: 28px;"></i>
                        </div>
                        <div class="message-content">
                            <p>您好！😊 我是淘东电商的智能客服小淘，很高兴为您服务！</p>
                            <p>请问有什么可以帮助您的呢？</p>
                            <p>💡 您可以点击左侧常见问题，或者直接输入问题哦~</p>
                        </div>
                    </div>
                </div>
                
                <!-- 输入区域 -->
                <div style="padding: 15px; background: #fff; border-top: 1px solid #eee; display: flex; align-items: center;">
                    <textarea id="messageInput" 
                              placeholder="请输入您的问题，按Enter发送..." 
                              style="flex: 1; height: 60px; padding: 10px; border: 1px solid #ddd; border-radius: 4px; resize: none; outline: none; font-size: 14px;"></textarea>
                    <button id="sendBtn" 
                            class="layui-btn layui-btn-normal" 
                            onclick="sendMessage()" 
                            style="margin-left: 15px; height: 60px; width: 100px; background: #ff6b00;">
                        <i class="layui-icon layui-icon-send"></i> 发送
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<style>
.quick-question {
    padding: 12px 15px;
    background: #f8f9fa;
    border-radius: 6px;
    margin-bottom: 10px;
    cursor: pointer;
    transition: all 0.3s;
    color: #333;
    font-size: 14px;
}
.quick-question:hover {
    background: #ff6b00;
    color: white;
    transform: translateX(5px);
}
.quick-question i {
    margin-right: 8px;
}
.message {
    display: flex;
    margin-bottom: 20px;
}
.user-message {
    flex-direction: row-reverse;
}
.message-avatar {
    width: 45px;
    height: 45px;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-shrink: 0;
    margin: 0 12px;
}
.ai-message .message-avatar {
    background: linear-gradient(135deg, #ff6b00 0%, #ff8c00 100%);
    color: white;
}
.user-message .message-avatar {
    background: linear-gradient(135deg, #009688 0%, #4caf50 100%);
    color: white;
}
.message-content {
    max-width: 60%;
    padding: 12px 18px;
    border-radius: 12px;
    background: white;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    line-height: 1.8;
}
.user-message .message-content {
    background: linear-gradient(135deg, #009688 0%, #4caf50 100%);
    color: white;
}
.message-content p {
    margin: 5px 0;
}
.typing-indicator {
    display: flex;
    padding: 15px;
}
.typing-dot {
    width: 8px;
    height: 8px;
    background: #ff6b00;
    border-radius: 50%;
    margin: 0 3px;
    animation: typing 1.4s infinite ease-in-out;
}
.typing-dot:nth-child(1) { animation-delay: 0s; }
.typing-dot:nth-child(2) { animation-delay: 0.2s; }
.typing-dot:nth-child(3) { animation-delay: 0.4s; }
@keyframes typing {
    0%, 80%, 100% { transform: scale(0.6); opacity: 0.5; }
    40% { transform: scale(1); opacity: 1; }
}
</style>

<script>
layui.use(['layer'], function(){
    var layer = layui.layer;
    
    // 回车发送
    document.getElementById('messageInput').addEventListener('keydown', function(e) {
        if (e.key === 'Enter' && !e.shiftKey) {
            e.preventDefault();
            sendMessage();
        }
    });
    
    // 加载历史记录
    loadHistory();
});

function sendQuickQuestion(question) {
    document.getElementById('messageInput').value = question;
    sendMessage();
}

function sendMessage() {
    var input = document.getElementById('messageInput');
    var message = input.value.trim();
    
    if (!message) return;
    
    // 显示用户消息
    addMessage(message, 'user');
    input.value = '';
    
    // 显示输入动画
    showTypingIndicator();
    
    // 调用API
    fetch('/api/ai/chat', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ message: message })
    })
    .then(response => response.json())
    .then(data => {
        removeTypingIndicator();
        if (data.success) {
            addMessage(data.reply, 'ai');
        } else {
            addMessage('抱歉，服务暂时不可用，请稍后再试~', 'ai');
        }
    })
    .catch(error => {
        removeTypingIndicator();
        console.error('Error:', error);
        addMessage('抱歉，网络连接失败，请稍后再试~', 'ai');
    });
}

function addMessage(content, type) {
    var chatArea = document.getElementById('chatArea');
    var messageDiv = document.createElement('div');
    messageDiv.className = 'message ' + (type === 'user' ? 'user-message' : 'ai-message');
    
    var avatarDiv = document.createElement('div');
    avatarDiv.className = 'message-avatar';
    avatarDiv.innerHTML = '<i class="layui-icon ' + (type === 'user' ? 'layui-icon-username' : 'layui-icon-face-smile') + '" style="font-size: 26px;"></i>';
    
    var contentDiv = document.createElement('div');
    contentDiv.className = 'message-content';
    contentDiv.innerHTML = content.split('\n').map(line => '<p>' + line + '</p>').join('');
    
    messageDiv.appendChild(avatarDiv);
    messageDiv.appendChild(contentDiv);
    chatArea.appendChild(messageDiv);
    
    chatArea.scrollTop = chatArea.scrollHeight;
}

function showTypingIndicator() {
    var chatArea = document.getElementById('chatArea');
    var indicatorDiv = document.createElement('div');
    indicatorDiv.id = 'typingIndicator';
    indicatorDiv.className = 'message ai-message';
    indicatorDiv.innerHTML = '<div class="message-avatar"><i class="layui-icon layui-icon-face-smile" style="font-size: 26px;"></i></div>' +
        '<div class="message-content"><div class="typing-indicator">' +
        '<div class="typing-dot"></div>' +
        '<div class="typing-dot"></div>' +
        '<div class="typing-dot"></div>' +
        '</div></div>';
    chatArea.appendChild(indicatorDiv);
    chatArea.scrollTop = chatArea.scrollHeight;
}

function removeTypingIndicator() {
    var indicator = document.getElementById('typingIndicator');
    if (indicator) {
        indicator.remove();
    }
}

function clearChat() {
    var chatArea = document.getElementById('chatArea');
    chatArea.innerHTML = '<div class="message ai-message">' +
        '<div class="message-avatar">' +
        '<i class="layui-icon layui-icon-face-smile" style="font-size: 28px;"></i>' +
        '</div>' +
        '<div class="message-content">' +
        '<p>您好！😊 我是淘东电商的智能客服小淘，很高兴为您服务！</p>' +
        '<p>请问有什么可以帮助您的呢？</p>' +
        '</div>' +
        '</div>';
    
    fetch('/api/ai/clear', { method: 'POST' });
}

function loadHistory() {
    fetch('/api/ai/history')
        .then(response => response.json())
        .then(data => {
            if (data.success && data.history && data.history.length > 0) {
                var chatArea = document.getElementById('chatArea');
                chatArea.innerHTML = '';
                data.history.forEach(function(msg) {
                    addMessage(msg.content, msg.role === 'user' ? 'user' : 'ai');
                });
            }
        });
}
</script>

<#include "base/bottom.ftl"/>
