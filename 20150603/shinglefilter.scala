import org.nlp4l.core.analysis.AnalyzerBuilder

val ab = AnalyzerBuilder()

ab.withTokenizer("standard")
ab.addTokenFilter("shingle", "minShingleSize", "2", "maxShingleSize", "2", "outputUnigrams", "false")
ab.addTokenFilter("lowercase")

val analyzer = ab.build()

analyzer.tokens("NLP4L is a Natural Language Processing tool for Lucene").map(_.getOrElse("term", null)).foreach(println(_))
