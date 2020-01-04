package com.base.library

interface ICovert<in T, R> {

    fun covert(entity: T): R
}