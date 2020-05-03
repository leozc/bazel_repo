package(default_visibility = ["//visibility:public"])
load("@rules_python//python:defs.bzl", "py_binary", "py_test", "py_library")


load("@3rdparty//:requirements.bzl", "requirement")
py_library(
    name = "lib",
    srcs = ["lib.py"],
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

# run with unzip -l bazel-bin/py_helloworld/runnable_bin.zip
# view with unzip -l bazel-bin/py_helloworld/runnable_bin.zip
py_binary(
    name = "runnable_bin",
    srcs = ["bin.py"],
    deps = [
        ":lib",
        requirement("numpy"),
        ],
    main = "bin.py",
    srcs_version="PY3",
)
# Run test
py_binary(
    name = "run_tests",
    main = "test/run.py",
    srcs = ["test/run.py"],
    deps = ["test_lib"],
)
