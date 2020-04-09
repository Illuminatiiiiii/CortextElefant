package com.noahhendrickson.util

import java.io.File

fun readFileLines(fileName: String?) = if (fileName == null) emptyList() else File(fileName).readLines()
