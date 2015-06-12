val analyzer = Analyzer(new org.apache.lucene.analysis.ja.JapaneseAnalyzer)

analyzer.tokens("私はビールとプログラミングと数学が好きです。").
filter(_.getOrElse("partOfSpeech",null).startsWith("名詞")).map(_.getOrElse("term",null))