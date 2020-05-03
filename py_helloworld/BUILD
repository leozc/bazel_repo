package(default_visibility = ["//visibility:public"])

py_library(
    name = "lib",
    srcs = ["lib.py"],
)

py_binary(
    name = "bin",
    srcs = ["bin.py"],
    deps = [":lib"],
)



filegroup(
    name = "srcs",
    srcs = ["BUILD"] + glob(["**/*.py"]),
)

py_test(
    name = "test_one",
    srcs = ["test/test_one.py"],
    deps = ["sample"],
    imports=["."] # making sure the same namespace as the lib code
)

py_test(
    name = "test_two",
    srcs = ["test/test_two.py"],
    deps = ["sample"],
    imports=["."] # making sure the same namespace as the lib code
)

py_test(
    name = "test_three",
    srcs = ["test/test_three.py"],
    deps = ["sample"],
    imports=["."] # making sure the same namespace as the lib code

)

test_suite(
    name = "all_tests",
    tests = [
        "test_one",
        "test_two",
        "test_three",
    ],
)

py_library(
    name = "test_lib",
    srcs = glob(["test/*.py"]),
    deps = [
        "sample",
    ],
)

py_library(
    name = "sample",
    srcs = ["sample.py"],
)

py_binary(
    name = "run_tests",
    main = "test/run.py",
    srcs = ["test/run.py"],
    deps = ["test_lib"],
)
