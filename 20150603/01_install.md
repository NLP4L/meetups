# インストール

## sbt のインストール

http://www.scala-sbt.org/

手動インストールした場合は sbt コマンドへパスを通してください。

## NLP4L のインストール


```
$ git clone https://github.com/NLP4L/nlp4l.git
$ cd nlp4l
$ sbt pack
```

初回はScala処理系および依存ライブラリをダウンロードするため、数分かかります。

sbt pack で OutOfMemoryError が出る場合は、SBT_OPTS で最大ヒープサイズを指定してください。

```
export SBT_OPTS="-Xmx2g -XX:MaxPermSize=1g -Xss2m"
```

## 対話シェルの起動

Windowsユーザーの方へ:
起動スクリプトで指定している文字エンコーディングを Shift_JIS に変更してください。
```
// target/pack/bin/nlp4l.bat 92行目
SET CMDLINE=%JAVA_EXE% %JVM_OPT% "-Xmx512m" "-Dfile.encoding=UTF-8" ...
//ここを以下のように変更
SET CMDLINE=%JAVA_EXE% %JVM_OPT% "-Xmx512m" "-Dfile.encoding=Shift_JIS" ...
```

```
$ target/pack/bin/nlp4l
Welcome to NLP4L!
Type in expressions to have them evaluated.
Type :help for more information
Type :? for information about NLP4L utilities

nlp4l> :?
All utility methods for NLP4L shell. Type ":? <method>" for more details.
-----------------------------------------------------------------------------
Method                             	Brief Description
-----------------------------------------------------------------------------
open(indexDir)                     	open index
close                              	close index
status                             	display status / overview for current opened index
browseTerms(field, [pageSize])     	start browsing terms(words) for the field
topTerms([n])                      	display top N (default is 10) frequent terms for the field [*1]
nextTerms([skip])                  	show next terms [*1]
nt                                 	alias for "nextTerms(1)"
prevTerms([skip])                  	show previous terms [*1]
pt                                 	alias for "prevTerms(1)"
browseTermDocs(field, term, [pageSize])	start browsing docs for the term in the specified field
nextDocs([skip])                   	show next docs [*2]
nd                                 	alias for "nextDocs(1)"
prevDocs([skip])                   	show previous docs (required to call this after "browseTermDocs" [*2]
pd                                 	alias for "prevDocs(1)"
showDoc(docId, [fields])           	display (stored) field values for the document
downloadLdcc                       	download and extract Livedoor news corpus
downloadBrown                      	download and extract Brown corpus
downloadReuters                    	download and extract Reuters corpus
[*1] required to call this after "browseTerms"
[*2] required to call this after "browseTermDocs"
```

ヘルプが表示されれば正しくインストールできています。

## 対話型シェルの終了

```
nlp4l> :q
```
