def declare_maven(hash):
    native.maven_jar(
        name = hash["name"],
        artifact = hash["artifact"],
        sha1 = hash["sha1"],
        repository = hash["repository"]
    )
    native.bind(
        name = hash["bind"],
        actual = hash["actual"]
    )

def maven_dependencies(callback = declare_maven):
        callback({"artifact": "com.google.guava:guava:11.0.1", "lang": "java", "sha1": "57b40a943725d43610c898ac0169adf1b2d55742", "repository": "https://repo.maven.apache.org/maven2/", "name": "com_google_guava_guava", "actual": "@com_google_guava_guava//jar", "bind": "jar/com/google/guava/guava"})