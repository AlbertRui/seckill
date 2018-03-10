<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="dns-prefetch" href="https://assets-cdn.github.com">
    <link rel="dns-prefetch" href="https://avatars0.githubusercontent.com">
    <link rel="dns-prefetch" href="https://avatars1.githubusercontent.com">
    <link rel="dns-prefetch" href="https://avatars2.githubusercontent.com">
    <link rel="dns-prefetch" href="https://avatars3.githubusercontent.com">
    <link rel="dns-prefetch" href="https://github-cloud.s3.amazonaws.com">
    <link rel="dns-prefetch" href="https://user-images.githubusercontent.com/">
    <link crossorigin="anonymous" href="https://assets-cdn.github.com/assets/frameworks-a4bf54bef6fb.css"
          integrity="sha512-pL9Uvvb7LMqGC8jv/AyqZ7Ya6/HTgkhZzKwEsHOdsfaW2pr3fgzqjgKUSJfYkZ/klxwHrcu+tZwtNDTuw8vH6Q=="
          media="all" rel="stylesheet"/>
    <link crossorigin="anonymous" href="https://assets-cdn.github.com/assets/github-ac2ce2821692.css"
          integrity="sha512-rCzighaSpHExGRE92llR25LZC8/MLJasLsUQy1tLhH7xcN5gCVI6h5zhvCpX4b2Nkiw02aytdPF7WOfWUB/6iQ=="
          media="all" rel="stylesheet"/>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub">
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub">
    <meta content="Seckill - SSM实战项目——Java高并发秒杀API，详细流程+学习笔记" property="og:description"/>
    <link rel="assets" href="https://assets-cdn.github.com/">
    <link rel="web-socket"
          href="wss://live.github.com/_sockets/VjI6MjU2NDYzNjYyOjk5MTViYzM3YzZmYjAwNmUxOWE5MmMyMWM1Y2Q4NTZlNzk1MTlhNWQxMWJlYmVhZmUwZDhjZmFiZTc0MGU5YzY=--6f4a3043860e5e93422633f72a127ffe5f89daf9">
    <link rel="sudo-modal" href="/sessions/sudo_modal">
    <link rel="mask-icon" href="https://assets-cdn.github.com/pinned-octocat.svg" color="#000000">
    <link rel="icon" type="image/x-icon" class="js-site-favicon" href="https://assets-cdn.github.com/favicon.ico">
    <link rel="manifest" href="/manifest.json" crossOrigin="use-credentials">
</head>
<body class="logged-in env-production page-blob">
<div role="main" class="application-main ">
    <div itemscope itemtype="http://schema.org/SoftwareSourceCode" class="">
        <div id="js-repo-pjax-container" data-pjax-container>
            <div class="container new-discussion-timeline experiment-repo-nav  ">
                <div class="repository-content ">
                    <div class="file">
                        <div id="readme" class="readme blob instapaper_body">
                            <article class="markdown-body entry-content" itemprop="text">
                                <h1><a href="#ssm实战项目java高并发秒杀api" aria-hidden="true" class="anchor"
                                       id="user-content-ssm实战项目java高并发秒杀api">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>SSM实战项目——Java高并发秒杀API
                                </h1>
                                <h3><a href="#本文包括了项目的完整流程开发过程中遇到的各种坑的总结学习笔记和问题扩展如果觉得readme太长我在blog里进行了分章点击前往"
                                       aria-hidden="true" class="anchor"
                                       id="user-content-本文包括了项目的完整流程开发过程中遇到的各种坑的总结学习笔记和问题扩展如果觉得readme太长我在blog里进行了分章点击前往">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>本文包括了项目的完整流程+开发过程中遇到的各种坑的总结+学习笔记和问题扩展，如果觉得README太长，我在blog里进行了分章，<a
                                        href="http://blog.csdn.net/lewky_liu/article/details/78154502" rel="nofollow">点击前往</a>
                                </h3>
                                <h3><a href="#这是完成后的项目点我看看实际效果" aria-hidden="true" class="anchor"
                                       id="user-content-这是完成后的项目点我看看实际效果">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>这是完成后的项目，<a href="http://120.78.137.138:8080/" rel="nofollow">点我看看实际效果</a></h3>
                                <hr>
                                <h2><a href="#项目介绍" aria-hidden="true" class="anchor" id="user-content-项目介绍">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>项目介绍
                                </h2>
                                <blockquote>
                                    <p>何为秒杀？</p>
                                </blockquote>
                                <p>所谓“秒杀”，就是网络卖家发布一些超低价格的商品，所有买家在同一时间网上抢购的一种销售方式。由于商品价格低廉，往往一上架就被抢购一空，有时只用一秒钟。</p>
                                <blockquote>
                                    <p>为何选择Java高并发秒杀作为实战项目？</p>
                                </blockquote>
                                <ul>
                                    <li>秒杀业务场景具有典型事务特性</li>
                                    <li>秒杀/红包类需求越来越常见</li>
                                </ul>
                                <blockquote>
                                    <p>为何使用SpringMVC+Spring+MyBatis框架</p>
                                </blockquote>
                                <ul>
                                    <li>框架易于使用和轻量级</li>
                                    <li>低代码侵入性</li>
                                    <li>成熟的社区和用户群</li>
                                </ul>
                                <blockquote>
                                    <p>能从该项目得到什么收获？</p>
                                </blockquote>
                                <ul>
                                    <li>框架的使用和整合技巧</li>
                                    <li>秒杀分析过程与优化思路</li>
                                </ul>
                                <blockquote>
                                    <p>项目来源</p>
                                </blockquote>
                                <p>这是慕课网上的一个免费项目教学视频，名为Java高并发秒杀API，一共有如下四节课程，附带视频传送门（在视频中老师是用IDEA，本文用的是Eclipse）</p>
                                <ul>
                                    <li><a href="http://www.imooc.com/learn/587"
                                           rel="nofollow">Java高并发秒杀API之业务分析与DAO层</a></li>
                                    <li><a href="http://www.imooc.com/learn/631"
                                           rel="nofollow">Java高并发秒杀API之Service层</a></li>
                                    <li><a href="http://www.imooc.com/learn/630" rel="nofollow">Java高并发秒杀API之Web层</a>
                                    </li>
                                    <li><a href="http://www.imooc.com/learn/632" rel="nofollow">Java高并发秒杀API之高并发优化</a>
                                    </li>
                                </ul>
                                <h2><a href="#相关技术介绍" aria-hidden="true" class="anchor" id="user-content-相关技术介绍">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>相关技术介绍
                                </h2>
                                <blockquote>
                                    <p>MySQL</p>
                                </blockquote>
                                <ul>
                                    <li>表设计</li>
                                    <li>SQL技巧</li>
                                    <li>事务和行级锁</li>
                                </ul>
                                <blockquote>
                                    <p>MyBatis</p>
                                </blockquote>
                                <ul>
                                    <li>DAO层设计与开发</li>
                                    <li>MyBatis合理使用</li>
                                    <li>与Spring整合</li>
                                </ul>
                                <blockquote>
                                    <p>Spring</p>
                                </blockquote>
                                <ul>
                                    <li>Spring IOC整合Service</li>
                                    <li>声明式事务运用</li>
                                </ul>
                                <blockquote>
                                    <p>SpringMVC</p>
                                </blockquote>
                                <ul>
                                    <li>Restful借口设计和使用</li>
                                    <li>框架运作流程</li>
                                    <li>Controller开发技巧</li>
                                </ul>
                                <blockquote>
                                    <p>前端</p>
                                </blockquote>
                                <ul>
                                    <li>交互设计</li>
                                    <li>Bootstrap</li>
                                    <li>jQuery</li>
                                </ul>
                                <blockquote>
                                    <p>高并发</p>
                                </blockquote>
                                <ul>
                                    <li>高并发点和高并发分析</li>
                                    <li>优化思路并实现</li>
                                </ul>
                                <h2><a href="#开发环境" aria-hidden="true" class="anchor" id="user-content-开发环境">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>开发环境
                                </h2>
                                <ul>
                                    <li><strong>操作系统</strong>：Windows 8</li>
                                    <li><strong>IDE工具</strong>：Eclipse</li>
                                    <li><strong>JDK</strong>：JDK1.7</li>
                                    <li><strong>中间件</strong>：Tomcat 7.0</li>
                                    <li><strong>数据库</strong>：MySQL 5.0</li>
                                    <li><strong>构建工具</strong>：Maven</li>
                                    <li><strong>框架</strong>：SSM</li>
                                </ul>
                                <h2><a href="#项目总结" aria-hidden="true" class="anchor" id="user-content-项目总结">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>项目总结
                                </h2>
                                <blockquote>
                                    <p>本文根据慕课网的视频教学进行了相应的学习总结，全文较长，分为四节，附带CSDN传送门</p>
                                </blockquote>
                                <ul>
                                    <li><a href="http://blog.csdn.net/lewky_liu/article/details/78159983"
                                           rel="nofollow"><strong>Java高并发秒杀API(一)之业务分析与DAO层</strong></a></li>
                                    <li><a href="http://blog.csdn.net/lewky_liu/article/details/78162149"
                                           rel="nofollow"><strong>Java高并发秒杀API(二)之Service层</strong></a></li>
                                    <li><a href="http://blog.csdn.net/lewky_liu/article/details/78162153"
                                           rel="nofollow"><strong>Java高并发秒杀API(三)之Web层</strong></a></li>
                                    <li><a href="http://blog.csdn.net/lewky_liu/article/details/78166080"
                                           rel="nofollow"><strong>Java高并发秒杀API(四)之高并发优化</strong></a></li>
                                </ul>
                                <blockquote>
                                    <p>项目源码</p>
                                </blockquote>
                                <ul>
                                    <li><a href="http://download.csdn.net/download/lewky_liu/10013556"
                                           rel="nofollow"><strong>源码下载</strong></a></li>
                                    <li><a href="https://github.com/lewky/Seckill"><strong>GitHub地址</strong></a></li>
                                </ul>
                                <hr>
                                <h1><a href="#java高并发秒杀api一之业务分析与dao层" aria-hidden="true" class="anchor"
                                       id="user-content-java高并发秒杀api一之业务分析与dao层">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a><a href="http://blog.csdn.net/lewky_liu/article/details/78159983" rel="nofollow">Java高并发秒杀API(一)之业务分析与DAO层</a>
                                </h1>
                                <blockquote>
                                    <p>本SSM实战项目使用了Maven进行依赖管理，如果有不清楚Maven是什么的可以参考<a
                                            href="http://blog.csdn.net/lewky_liu/article/details/78138381"
                                            rel="nofollow">这篇文章</a></p>
                                </blockquote>
                                <h2><a href="#1-创建maven项目和依赖" aria-hidden="true" class="anchor"
                                       id="user-content-1-创建maven项目和依赖">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>1. 创建Maven项目和依赖
                                </h2>
                                <h3><a href="#11-创建项目前需要先安装maven并设置好环境变量" aria-hidden="true" class="anchor"
                                       id="user-content-11-创建项目前需要先安装maven并设置好环境变量">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>1.1 创建项目前需要先安装Maven，并设置好环境变量
                                </h3>
                                <ul>
                                    <li><a href="http://download.csdn.net/download/lewky_liu/10000144" rel="nofollow">Maven下载</a>
                                    </li>
                                    <li>设置环境变量
                                        <ul>
                                            <li>
                                                新建变量<code>MAVEN_HOME</code>，值为Maven的目录<code>X:\XXX\apache-maven-XXX</code>
                                            </li>
                                            <li>将<code>%MAVEN_HOME%\bin</code>添加到<code>Path</code>变量下</li>
                                        </ul>
                                    </li>
                                    <li>运行CMD，输入<code>mvn -v</code>后可以看到Maven的版本信息等则表示安装成功</li>
                                </ul>
                                <h3><a href="#12-创建maven项目有两种方式如下" aria-hidden="true" class="anchor"
                                       id="user-content-12-创建maven项目有两种方式如下">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>1.2 创建Maven项目有两种方式，如下
                                </h3>
                                <p><strong>第一种创建方式：使用命令行手动创建</strong></p>
                                <pre><code>mvn archetype:generate -DgroupId=com.lewis.seckill -DartifactId=seckill -Dpackage=com.lewis.seckill -Dversion=1.0-SNAPSHOT -DarchetypeArtifactId=maven-archetype-webapp</code></pre>
                                <p>在视频中使用的是<code>archetype:create</code>，该方法已被废弃，请使用<code>archetype:generate</code>来创建。命令行执行后会创建一个<code>maven-archetype-webapp</code>骨架的Maven项目，其中<code>groupId</code>是项目组织唯一的标识符，实际对应JAVA的包的结构；<code>artifactId</code>是项目的唯一的标识符，实际对应项目的名称；<code>package</code>一般是<code>groupId</code>+<code>artifactId</code>，是自动生成的，可以修改
                                </p>
                                <p><strong>第二种创建方式：借助IDE工具的Maven插件来创建项目</strong></p>
                                <blockquote>
                                    <p>Eclipse安装Maven插件</p>
                                </blockquote>
                                <ul>
                                    <li>不知道怎么Maven插件的请参考<a
                                            href="http://blog.csdn.net/wode_dream/article/details/38052639"
                                            rel="nofollow">该博文</a>，推荐使用link方式手工安装的方式
                                        <ul>
                                            <li>如果是手工安装Maven插件的，可能会缺少pom.xml 图形化编辑工具，请另外添加进去，具体情况请参考<a
                                                    href="http://www.micmiu.com/software/build/eclipse-m2e-plugins/"
                                                    rel="nofollow">该博文</a></li>
                                            <li>已经安装了Maven插件的请走下一个步骤</li>
                                        </ul>
                                    </li>
                                    <li><code>File</code>→<code>New</code>→<code>Other...</code>→<code>Maven
                                        Project</code>→<code>Next</code>,进入如下界面
                                    </li>
                                </ul>
                                <p>
                                    <a href="https://github.com/lewky/MarkdownImages/blob/master/resource/CSDN/Maven1.jpg?raw=true"
                                       target="_blank"><img
                                            src="https://github.com/lewky/MarkdownImages/raw/master/resource/CSDN/Maven1.jpg?raw=true"
                                            alt="Maven1" style="max-width:100%;"></a></p>
                                <ul>
                                    <li>点击<code>Next</code>，选择要构建的骨架<code>maven-archetype-webapp</code>，如下图</li>
                                </ul>
                                <p>
                                    <a href="https://github.com/lewky/MarkdownImages/blob/master/resource/CSDN/Maven2.jpg?raw=true"
                                       target="_blank"><img
                                            src="https://github.com/lewky/MarkdownImages/raw/master/resource/CSDN/Maven2.jpg?raw=true"
                                            alt="Maven2" style="max-width:100%;"></a></p>
                                <ul>
                                    <li>点击<code>Next</code>，填写<code>groupId=com.lewis.seckill</code>，<code>DartifactId=seckill</code>，<code>package=com.lewis.seckill</code>（根据实际情况填写），然后<code>Finish</code>
                                    </li>
                                </ul>
                                <blockquote>
                                    <p>如果是第一次使用Eclipse的Maven插件来创建Maven项目的可能会遇到一些问题，可以参考<a
                                            href="http://blog.csdn.net/lewky_liu/article/details/78138381"
                                            rel="nofollow">该博文</a></p>
                                </blockquote>
                                <h3><a href="#13-修改pomxml文件" aria-hidden="true" class="anchor"
                                       id="user-content-13-修改pomxml文件">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>1.3 修改pom.xml文件
                                </h3>
                                <p>
                                    当创建完Maven项目后会在根目录下有一个pom.xml文件，Maven项目通过pom.xml进行项目依赖的管理，如果没有该xml文件，Eclipse不会将该项目当作一个Maven项目</p>
                                <blockquote>
                                    <p>添加项目需要的jar包依赖</p>
                                </blockquote>
                                <blockquote>
                                    <p>关于maven依赖的简化写法</p>
                                </blockquote>
                                <p>
                                    教学视频中老师写了很多的依赖，但其实这里面有一些是可以省略不写的，因为有些包会自动依赖其它的包（Maven的传递性依赖）。这里面可以省略的依赖有：spring-core;spring-beans（上面这两个spring-context会自动依赖）;spring-context，spring-jdbc（mybatis-spring会依赖）；spring-web（spring-webmvc会依赖）；logback-core（logback-classic会依赖）</p>
                                <blockquote>
                                    <p>有想要了解Maven的依赖范围与传递性依赖的请参考<a
                                            href="http://blog.csdn.net/lewky_liu/article/details/78145211"
                                            rel="nofollow">该博文</a></p>
                                </blockquote>
                                <h2><a href="#2-秒杀业务分析" aria-hidden="true" class="anchor" id="user-content-2-秒杀业务分析">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>2. 秒杀业务分析
                                </h2>
                                <h3><a href="#21-业务分析" aria-hidden="true" class="anchor" id="user-content-21-业务分析">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>2.1 业务分析
                                </h3>
                                <blockquote>
                                    <p>秒杀业务的核心是对库存的处理，其业务流程如下图</p>
                                </blockquote>
                                <p>
                                    <a href="https://github.com/lewky/MarkdownImages/blob/master/resource/seckill/1.png?raw=true"
                                       target="_blank"><img
                                            src="https://github.com/lewky/MarkdownImages/raw/master/resource/seckill/1.png?raw=true"
                                            alt="1.png" style="max-width:100%;"></a></p>
                                <blockquote>
                                    <p>用户针对库存业务分析</p>
                                </blockquote>
                                <p>当用户执行秒杀成功时，应该发生以下两个操作：</p>
                                <ul>
                                    <li>减库存</li>
                                    <li>记录购买明细</li>
                                </ul>
                                <p>这两个操作属于一个完整事务，通过事务来实现数据落地</p>
                                <blockquote>
                                    <p>为什么需要事务？</p>
                                </blockquote>
                                <ul>
                                    <li>减库存却没有记录购买明细，会导致商品少卖</li>
                                    <li>记录购买明细却没有减库存，会导致商品超卖</li>
                                </ul>
                                <p>在实际中，以上都是很严重的事故，会给商家或买家带来损失，这是不能被允许的。一旦发生这种事故，事故责任很自然的就会去找设计实现业务的程序员</p>
                                <blockquote>
                                    <p>如何实现数据落地？</p>
                                </blockquote>
                                <p>有<strong>MySQL与NoSQL</strong>两种数据落地的方案</p>
                                <ul>
                                    <li>
                                        MySQL属于关系型数据库，而MySQL内置的事务机制来可以准确的帮我们完成减库存和记录购买明细的过程。MySQL有多种存储引擎，但只有InnoDB存储引擎支持事务。InnoDB支持行级锁和表级锁，默认使用行级锁
                                    </li>
                                    <li>NoSQL属于非关系型数据库，近些年来在数据存储方面承担了很大的职责，但是对于事务的支持做的并不是很好，更多追求的是性能、高复用、分布式。</li>
                                </ul>
                                <p>事务机制依然是目前最可靠的数据落地方案。</p>
                                <blockquote>
                                    <p>数据落地与不数据落地</p>
                                </blockquote>
                                <ul>
                                    <li><strong>落地数据</strong>：就是被持久化的数据，这种数据一般放在硬盘或是其他的持久化存储设备里，例如：图片、系统日志、在页面上显示的数据以及保存在关系数据库里的数据等等，落地数据一定会有一个固定的载体，他们不会瞬时消失的。
                                    </li>
                                    <li><strong>不落地数据</strong>：一般指存储在内存或者是网络传输里的数据，这些数据是瞬时，使用完毕就会消失，例如：我们在浏览器发送给服务器的请求；从数据库读取出来的一直到页面展示前的数据等等。
                                    </li>
                                    <li>“不落地”传输能够满足用户在性能上的要求。</li>
                                </ul>
                                <h3><a href="#22-使用mysql实现秒杀的难点分析" aria-hidden="true" class="anchor"
                                       id="user-content-22-使用mysql实现秒杀的难点分析">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>2.2 使用MySQL实现秒杀的难点分析
                                </h3>
                                <blockquote>
                                    <p>难点问题：如何高效地处理竞争？</p>
                                </blockquote>
                                <p>当一个用户在执行秒杀某件商品时，其他也想要秒杀该商品的用户就只能等待，直到上一个用户提交或回滚了事务，他才能够得到该商品的锁执行秒杀操作。这里就涉及到了锁的竞争。</p>
                                <p>
                                    <a href="https://github.com/lewky/MarkdownImages/blob/master/resource/seckill/2.jpg?raw=true"
                                       target="_blank"><img
                                            src="https://github.com/lewky/MarkdownImages/raw/master/resource/seckill/2.jpg?raw=true"
                                            alt="2.jpg" style="max-width:100%;"></a></p>
                                <p>对于MySQL来说，竞争反应到背后的技术是就是事务+行级锁：</p>
                                <p>start transaction（开启事务）→ update库存数量 → insert购买明细 → commit（提交事务）</p>
                                <p>在秒杀系统中，在同一时刻会有很多用户在秒杀同一件商品，那么如何高效低处理这些竞争？如何高效地提交事务？这些将在<a
                                        href="http://blog.csdn.net/lewky_liu/article/details/78166080" rel="nofollow">Java高并发秒杀API(四)之高并发优化</a>进行分析总结。
                                </p>
                                <blockquote>
                                    <p>实现哪些秒杀功能？</p>
                                </blockquote>
                                <p>下面先以天猫的秒杀库存系统为例，如下图</p>
                                <p>
                                    <a href="https://github.com/lewky/MarkdownImages/blob/master/resource/seckill/3.jpg?raw=true"
                                       target="_blank"><img
                                            src="https://github.com/lewky/MarkdownImages/raw/master/resource/seckill/3.jpg?raw=true"
                                            alt="3.jpg" style="max-width:100%;"></a></p>
                                <p>可以看到，天猫的秒杀库存系统是很复杂的，需要很多工程师共同开发。在这里，我们只实现秒杀相关的功能</p>
                                <ul>
                                    <li>秒杀接口暴露</li>
                                    <li>执行秒杀</li>
                                    <li>相关查询</li>
                                </ul>
                                <blockquote>
                                    <p>为什么要进行秒杀接口暴露的操作？</p>
                                </blockquote>
                                <p>现实中有的用户回通过浏览器插件提前知道秒杀接口，填入参数和地址来实现自动秒杀，这对于其他用户来说是不公平的，我们也不希望看到这种情况</p>
                                <h2><a href="#3-dao层设计" aria-hidden="true" class="anchor" id="user-content-3-dao层设计">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>3. DAO层设计
                                </h2>
                                <h3><a href="#31-创建数据库" aria-hidden="true" class="anchor" id="user-content-31-创建数据库">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>3.1 创建数据库
                                </h3>
                                <p>源码里有个sql文件夹，可以给出了sql语句；也可以选择自己手写。数据库一共就两个表：秒杀库存表、秒杀成功明细表。</p>
                                <blockquote>
                                    <p>秒杀成功明细表为何使用联合主键</p>
                                </blockquote>
                                <p>之所以使用联合主键，是为了能够过滤重复插入，可以通过<code>insert ignore into</code>语句来避免用户重复秒杀同一件商品。这样当有重复记录就会忽略，语句执行后返回数字0。
                                </p>
                                <blockquote>
                                    <p>可能存在的问题</p>
                                </blockquote>
                                <p>安装视频里的建表过程，可能会出现建表失败的情况。原因是当你给一个timestamp设置为on update
                                    current_timestamp的时候，其他的timestamp字段需要显式设定default值。</p>
                                <p>
                                    但是如果你有两个timestamp字段，但是只把第一个设定为current_timestamp而第二个没有设定默认值，MySQL也能成功建表,但是反过来就不行。这是mysql5.5版本对timestamp的处理。</p>
                                <p>为了解决这个问题，将create_time放到start_time和end_time的前面，还有的mysql版本需要将三个时间戳都设置默认值。</p>
                                <h3><a href="#32-创建数据表对应的实体类" aria-hidden="true" class="anchor"
                                       id="user-content-32-创建数据表对应的实体类">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>3.2 创建数据表对应的实体类
                                </h3>
                                <blockquote>
                                    <p>在<code>src/main/java</code>包下创建com.lewis.entity包，接着建立<code>Seckill</code>实体类</p>
                                </blockquote>
                                <blockquote>
                                    <p>在com.lewis.entity包下，接着建立<code>SuccessKilled</code>实体类</p>
                                </blockquote>
                                <h3><a href="#33-创建实体类对应的dao层接口也就是mapper接口dao针对的是具体实体来操作的实体的增删改查" aria-hidden="true"
                                       class="anchor"
                                       id="user-content-33-创建实体类对应的dao层接口也就是mapper接口dao针对的是具体实体来操作的实体的增删改查">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>3.3 创建实体类对应的DAO层接口（也就是Mapper接口，DAO针对的是具体实体来操作的“实体的增删改查”）
                                </h3>
                                <blockquote>
                                    <p>
                                        在<code>src/main/java</code>下建立com.lewis.dao包，在包下建立SeckillDao接口
                                    </p>
                                </blockquote>
                                <blockquote>
                                    <p>在<code>com.lewis.dao</code>包下建立<code>SuccessKilledDao</code>接口</p>
                                </blockquote>
                                <blockquote>
                                    <p>为什么有的方法形参前有@Param，有的却没有？</p>
                                </blockquote>
                                <p>
                                    从上面的代码可以发现，当方法的形参在两个及两个以上时，需要在参数前加上@Param，如果不加上该注解会在之后的测试运行时报错。这是Sun提供的默认编译器（javac）在编译后的Class文件中会丢失参数的实际名称，方法中的形参会变成无意义的arg0、arg1等，在只有一个参数时就无所谓，但当参数在两个和两个以上时，传入方法的参数就会找不到对应的形参。因为Java形参的问题，所以在多个基本类型参数时需要用@Param注解区分开来。</p>
                                <h3><a href="#34-基于mybatis实现dao接口" aria-hidden="true" class="anchor"
                                       id="user-content-34-基于mybatis实现dao接口">
                                    <svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1"
                                         viewBox="0 0 16 16" width="16">
                                        <path fill-rule="evenodd"
                                              d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path>
                                    </svg>
                                </a>3.4 基于MyBatis实现DAO接口
                                </h3>
                                <blockquote>
                                    <p>MyBatis怎么用？SQL写在哪里？</p>
                                </blockquote>
                                <p>Mybatis有两种提供SQL的方式：XML提供SQL、注解提供SQL（注解是java5.0之后提供的一个新特性）。</p>
                                <p>
                                    对于实际的使用中建议使用XML文件的方式提供SQL。如果通过注解的方式提供SQL，由于注解本身还是java源码，这对于修改和调整SQL其实是非常不方便的，一样需要重新编译类，当我们写复杂的SQL尤其拼接逻辑时，注解处理起来就会非常繁琐。而XML提供了很多的SQL拼接和处理逻辑的标签，可以非常方便的帮我们去做封装。</p>
                                <blockquote>
                                    <p>如何去实现DAO接口？</p>
                                </blockquote>
                                <p>
                                    Mapper自动实现DAO（也就是DAO只需要设计接口，不需要去写实现类，MyBatis知道我们的参数、返回类型是什么，同时也有SQL文件，它可以自动帮我们生成接口的实现类来帮我们执行参数的封装，执行SQL，把我们的返回结果集封装成我们想要的类型）
                                    。</p>
                                <p>第二种是通过API编程方式实现DAO接口（MyBatis通过给我们提供了非常多的API，跟其他的ORM和JDBC很像）</p>
                                <p>
                                    在实际开发中建议使用Mapper自动实现DAO，这样可以直接只关注SQL如何编写，如何去设计DAO接口，帮我们节省了很多的维护程序，所有的实现都是MyBatis自动完成。</p>
                                <blockquote>
                                    <p>创建一个目录存放Mybatis的SQL映射</p>
                                </blockquote>
                                <p>按照Maven的规范，SQL映射文件应该放在<code>src/main/resources</code>包下，在该包下建立<code>mapper</code>目录，用来存放映射DAO接口的XML文件。这样Maven在编译时就会自动将<code>src/main/resources</code>下的这些配置文件编译进来。
                                </p>
                                <p>我们也可以按照原本的习惯，在<code>src/main/java</code>下建立<code>com.lewis.mapper</code>包，将这些SQL映射存放到这里。由于Maven默认不会编译<code>src/main/java</code>下除源码以外的文件，所以需要在pom.xml中进行额外的配置。
                                </p>
                                <pre><code>&lt;build&gt;
	&lt;finalName&gt;seckill&lt;/finalName&gt;
	&lt;resources&gt;
		&lt;!--打包时包含源代码包下的资源文件，默认情况下只会打包src/main/java下的源代码 --&gt;
		&lt;resource&gt;
			&lt;directory&gt;src/main/java&lt;/directory&gt;
			&lt;includes&gt;
				&lt;include&gt;**/*.xml&lt;/include&gt;
			&lt;/includes&gt;
			&lt;filtering&gt;false&lt;/filtering&gt;
		&lt;/resource&gt;
		&lt;resource&gt;
			&lt;directory&gt;src/main/resources&lt;/directory&gt;
		&lt;/resource&gt;
	&lt;/resources&gt;
&lt;/build&gt;
</code></pre>
                                <p>
                                    在本项目中，我是采用的第二种方式存放Mybatis的SQL映射。（只是将映射DAO的mapper文件放在java包下，其他的关于Spring、MyBatis等的配置文件还是放在resources包下）</p>
                                <blockquote>
                                    <p>在<code>src/main/resources</code>目录下配置mybatis-config.xml（配置MyBatis的全局属性）</p>
                                </blockquote>
                                <p>打开MyBatis的<a href="http://www.mybatis.org/mybatis-3/zh/index.html" rel="nofollow">官方文档</a>（MyBatis的官方文档做的非常友好，提供了非常多版本的国际化支持），选择<code>入门</code>，找到MyBatis全局配置，里面有XML的规范（XML的标签约束dtd文件），拷入到项目的MyBatis全局配置文件中，开始配置MyBatis，如下：
                                </p>
                                <pre><code>&lt;?xml version="1.0" encoding="UTF-8" ?&gt;
&lt;!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd"&gt;
&lt;configuration&gt;
	&lt;!--配置全局属性 --&gt;
	&lt;settings&gt;
		&lt;!--使用jdbc的getGeneratekeys获取自增主键值，默认是false
			当inert一条记录时我们是不插入id的，id是通过自增去赋值的
			当插入完后想得到该插入记录的id时可以调用jdbc的getGeneratekeys --&gt;
		&lt;setting name="useGeneratedKeys" value="true" /&gt;
		
		&lt;!--使用列别名替换列名 默认值为true（可以不用写出来，这里写出来只是为了讲解该配置的作用）
			select name as title(实体中的属性名是title) form table; 
			开启后mybatis会自动帮我们把表中name的值赋到对应实体的title属性中 --&gt;
		&lt;setting name="useColumnLabel" value="true" /&gt;

		&lt;!--开启驼峰命名转换Table:create_time到 Entity(createTime) --&gt;
		&lt;setting name="mapUnderscoreToCamelCase" value="true" /&gt;
	&lt;/settings&gt;

&lt;/configuration&gt;
</code></pre>
                                <blockquote>
                                    <p>在<code>src/main/java</code>目录下的<code>com.lewis.mapper</code>包里创建SeckillDao.xml
                                    </p>
                                </blockquote>
                                <blockquote>
                                    <p>在<code>src/main/java</code>目录下的<code>com.lewis.mapper</code>包里创建SuccessKilledDao.xml
                                    </p>
                                </blockquote>
                                <p>注：上面的s.seckill_id
                                    “seckill.seckill_id”表示s.seckill_id这一列的数据是Success_killed实体类里的seckill属性里的seckill_id属性，是一个级联的过程，使用的就是别名只是忽略了as关键字，别名要加上双引号。</p>
                                <blockquote>
                                    <p>为什么要用<code>&lt;![CDATA[]]&gt;</code>把<code>&lt;=</code>给包起来</p>
                                </blockquote>
                                <p>CDATA指的是不应由 XML 解析器进行解析的文本数据，在XML元素中，<code>&lt;</code>和<code>&amp;</code>是非法的：</p>
                                <ul>
                                    <li><code>&lt;</code>会产生错误，因为解析器会把该字符解释为新元素的开始。</li>
                                    <li><code>&amp;</code>也会产生错误，因为解析器会把该字符解释为字符实体的开始。（字符实体：比如<code>&amp;nbsp;</code>表示一个空格）
                                    </li>
                                </ul>
                                <p>所以在这里我们需要使用<code>&lt;![CDATA[ &lt;= ]]&gt;来告诉XML<code>&lt;=不是XML的语言.</p>
                                <h3>3.5 整合Spring和MyBatis</h3>
                                <p>在<code>resources</code>目录下创建一个新的目录<code>spring</code>(存放所有Spring相关的配置)</p>
                                <blockquote>
                                    <p>在resources包下创建jdbc.properties，用于配置数据库的连接信息</p>
                                </blockquote>
                                <blockquote>
                                    <p>在<code>resources/spring</code>目录下创建Spring关于DAO层的配置文件spring-dao.xml</p>
                                </blockquote>
                                <blockquote>
                                    <p>关于数据库连接池的配置可能出现的问题</p>
                                </blockquote>
                                <p>
                                    在jdbc.properties里使用的是<code>jdbc.username</code>，而不是<code>username</code>或者<code>name</code>，这是因为后两个属性名可能会与全局变量冲突，导致连接的数据库用户名变成了电脑的用户名，所以使用了<code>jdbc.username</code>。
                                </p>
                                <blockquote>
                                    <p>相关链接</p>
                                </blockquote>
                                <p>关于Spring的XML配置文件的头部文件的说明可以参考<a
                                        href="http://blog.csdn.net/lewky_liu/article/details/78157747" rel="nofollow">这篇文章</a>
                                </p>
                                <h3>3.6 DAO层单元测试</h3>
                                <p>有不知道Eclipse如何直接进行生成快速的测试单元的，可以看看<a
                                        href="http://blog.csdn.net/jj_nan/article/details/64134781"
                                        rel="nofollow">这篇文章</a></p>
                                <p>使用Eclipse工具直接生成测试单元，这些测试代码按照Maven规范放到<code>src/test/java</code>包下。在生成的测试代码里测试我们的方法，测试的具体代码如下：
                                </p>
                                <blockquote>
                                    <p><code>SeckillDaoTest.java</code></p>
                                </blockquote>
                                <blockquote>
                                    <p>测试说明</p>
                                </blockquote>
                                <p>先左键单击要测试的那个方法名，再右键点击选择<code>Debug As</code>可以单独对该方法进行单元测试。三个方法都测试通过，但是对于最后一个方法会发现数据库中该商品数量并没有减少，这是因为我们设置了秒杀时间，当前时间不满足秒杀时间，所以不会秒杀成功减少数量。
                                </p>
                                <p>
                                    如果之前没有在DAO接口的多参数方法里在形参前加上@Param注解，那么在这里进行单元测试时，MyBatis会报绑定参数失败的错误，因为无法找到参数。这是因为Java没有保存行参的记录，Java在运行的时候会把<code>queryAll(int
                                    offset,int limit)</code>中的参数变成这样<code>queryAll(int arg0,int arg1)</code>，导致MyBatis无法识别这两个参数。
                                </p>
                                <blockquote>
                                    <p><code>SuccessKilledDaoTest.java</code></p>
                                </blockquote>
                                <blockquote>
                                    <p>测试说明</p>
                                </blockquote>
                                <p>
                                    测试方法同上，测试结果通过，另外由于我们使用了联合主键，在insert时使用了ignore关键字，所以对于<code>testInsertSuccessKilled()</code>重复插入同一条数据是无效的，会被过滤掉，确保了一个用户不能重复秒杀同一件商品。
                                </p>
                                <blockquote>
                                    <p>本节结语</p>
                                </blockquote>
                                <p>至此，关于Java高并发秒杀API的DAO层的开发与测试已经完成，接下来进行Service层的开发、测试，详情可以参考<a
                                        href="http://blog.csdn.net/lewky_liu/article/details/78162149" rel="nofollow">Java高并发秒杀API(二)之Service层</a>。
                                </p>
                            </article>
                        </div>
                    </div>
                </div>
                <div class="modal-backdrop js-touch-events"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

