import org.nlp4l.core.analysis.AnalyzerBuilder

val STR = "NLP4L is a Natural Language Processing tool for Lucene"

// bi-gram
val ab2 = AnalyzerBuilder()

ab2.withTokenizer("standard")
ab2.addTokenFilter("shingle", "minShingleSize", "2", "maxShingleSize", "2", "outputUnigrams", "false")
ab2.addTokenFilter("lowercase")

val analyzer2 = ab2.build()

println("\n\n--- bi-gram ---")
analyzer2.tokens(STR).map(_.getOrElse("term", null)).foreach(println(_))

// tri-gram
val ab3 = AnalyzerBuilder()

ab3.withTokenizer("standard")
ab3.addTokenFilter("shingle", "minShingleSize", "3", "maxShingleSize", "3", "outputUnigrams", "false")
ab3.addTokenFilter("lowercase")

val analyzer3 = ab3.build()

println("\n\n--- tri-gram ---")
analyzer3.tokens(STR).map(_.getOrElse("term", null)).foreach(println(_))
