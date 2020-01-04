package com.component.base

import com.base.library.ICovert
import com.component.base.model.BaseModel

class CovertTest<T> : ICovert<BaseModel<T>, T> {
    override fun covert(entity: BaseModel<T>): T {
        return entity.result!!
    }
}