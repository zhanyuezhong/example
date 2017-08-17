package com.zyz.netty.timeserver;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * User: 张月忠
 * Date: 2017/8/9
 * Time: 下午2:14
 * To change this template use File | Settings | File Templates.
 */

public class TimeServer {

    private void bind(int prot){
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup).
                    channel(NioServerSocketChannel.class).
                    option(ChannelOption.SO_BACKLOG,2014).
                    handler(new ChannelInitializer<ServerSocketChannel>() {
                        @Override
                        protected void initChannel(ServerSocketChannel serverSocketChannel) throws Exception {
                            serverSocketChannel.pipeline().addLast(null);
                        }
                    });


        }catch (Exception e){
            
        }
    }
}
