<H2>Spring Bootで、以下の2つの機能の実装サンプル</H2>
<ul>
<li>複数DBへの接続（JdbcTemplateを利用）</li>
<li>Session情報の複数回取得対応</li>
</ul>

<H3>複数DBへの接続（JdbcTemplateを利用）</H3>
<ul>
<li>各DBへの接続文字列はapplication.propertiesに記述し、その読み込みに@ConfigurationProperties(prefix = "spring.datasource.primary")、@ConfigurationProperties(prefix = "spring.datasource.secondary")アノテーションを使っている。</li>
<li>個々のJdbcTemplateクラスをnewしてインスタンスを作れば各DBへのアクセスは可能だが、このやり方だとAspectJを利用したSQLログ出力ができない。Aspectを使ったSQLログ出力には、Autowiredでのインスタンス取得が必要。そのため、@Bean(name="[識別文字列]")、@Qualifier("[識別文字列]")を使い、個々のJdbcTemplate、およびDataSourceのAutowired先を指定する方法を採る。</li>
</ul>

<H3>Session情報の複数回取得対応</H3>
HttpRequestクラスの情報は、1度しか読み込めない（readLine()を2回以上実行すると、エラーが発生する）。そのため、Filter側で1度参照し、RESTController側でもう1度参照する、ということが出来ない。これを回避するために、HttpRequestクラスを別クラスにコピーする。別クラスと言っても、HttpServletRequestクラスとして扱えるよう、以下の手法で実装する。
<ul>
  <li>ServletInputStream、HttpServletRequestWrapperを継承したクラスを用意する</li>
  <li>HttpServletRequestWrapperの中で、HTTP通信受信時のHttpServletRequestの内容をコピーする処理を実装する</li>
</ul>
今回はサンプルとして、Filterクラス側で上記のクラスを利用した処理を実装している。
