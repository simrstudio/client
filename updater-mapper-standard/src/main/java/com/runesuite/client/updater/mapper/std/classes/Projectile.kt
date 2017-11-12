package com.runesuite.client.updater.mapper.std.classes

import org.kxtra.lang.list.startsWith
import com.runesuite.mapper.IdentityMapper
import com.runesuite.mapper.OrderMapper
import com.runesuite.mapper.annotations.DependsOn
import com.runesuite.mapper.annotations.MethodParameters
import com.runesuite.mapper.extensions.and
import com.runesuite.mapper.extensions.predicateOf
import com.runesuite.mapper.tree.Class2
import com.runesuite.mapper.tree.Field2
import com.runesuite.mapper.tree.Instruction2
import com.runesuite.mapper.tree.Method2
import org.objectweb.asm.Opcodes.GETFIELD
import org.objectweb.asm.Opcodes.PUTFIELD
import org.objectweb.asm.Type.*

@DependsOn(Entity::class)
class Projectile : IdentityMapper.Class() {
    override val predicate = predicateOf<Class2> { it.superType == type<Entity>() }
            .and { it.instanceFields.count { it.type == DOUBLE_TYPE } >= 8 }

    class id : OrderMapper.InConstructor.Field(Projectile::class, 2) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    @DependsOn(SequenceDefinition::class)
    class sequenceDefinition : IdentityMapper.InstanceField() {
        override val predicate = predicateOf<Field2> { it.type == type<SequenceDefinition>() }
    }

    @MethodParameters
    @DependsOn(Entity.getModel::class)
    class getModel : InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.mark == method<Entity.getModel>().mark }
    }

    class update : InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == VOID_TYPE }
                .and { it.arguments.startsWith(INT_TYPE) }
                .and { it.arguments.size in 1..2 }
    }

    class adjust : InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == VOID_TYPE }
                .and { it.arguments.startsWith(INT_TYPE, INT_TYPE, INT_TYPE) }
    }

    @DependsOn(getModel::class)
    class pitch : OrderMapper.InMethod.Field(getModel::class, -1) {
        override val predicate = predicateOf<Instruction2> { it.opcode == GETFIELD && it.fieldType == INT_TYPE }
    }

    class sourceX : OrderMapper.InConstructor.Field(Projectile::class, 4) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class sourceY : OrderMapper.InConstructor.Field(Projectile::class, 5) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class sourceZ : OrderMapper.InConstructor.Field(Projectile::class, 6) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class plane : OrderMapper.InConstructor.Field(Projectile::class, 3) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class targetIndex : OrderMapper.InConstructor.Field(Projectile::class, 11) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class isMoving : OrderMapper.InConstructor.Field(Projectile::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == BOOLEAN_TYPE }
    }

    @DependsOn(update::class)
    class x : OrderMapper.InMethod.Field(update::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == DOUBLE_TYPE }
    }

    @DependsOn(update::class)
    class y : OrderMapper.InMethod.Field(update::class, 1) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == DOUBLE_TYPE }
    }

    @DependsOn(update::class)
    class z : OrderMapper.InMethod.Field(update::class, 2) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == DOUBLE_TYPE }
    }

    @DependsOn(update::class)
    class speedX : OrderMapper.InMethod.Field(update::class, 1) {
        override val predicate = predicateOf<Instruction2> { it.opcode == GETFIELD && it.fieldType == DOUBLE_TYPE }
    }

    @DependsOn(update::class)
    class speedY : OrderMapper.InMethod.Field(update::class, 3) {
        override val predicate = predicateOf<Instruction2> { it.opcode == GETFIELD && it.fieldType == DOUBLE_TYPE }
    }

    @DependsOn(update::class)
    class speedZ : OrderMapper.InMethod.Field(update::class, 3) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == DOUBLE_TYPE }
    }

    @DependsOn(update::class)
    class yaw : OrderMapper.InMethod.Field(update::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    @DependsOn(adjust::class)
    class speed : OrderMapper.InMethod.Field(adjust::class, -3) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == DOUBLE_TYPE }
    }

    @DependsOn(adjust::class)
    class accelerationZ : OrderMapper.InMethod.Field(adjust::class, -1) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == DOUBLE_TYPE }
    }

    class int1 : OrderMapper.InConstructor.Field(Projectile::class, 7) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class int2 : OrderMapper.InConstructor.Field(Projectile::class, 8) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class int3 : OrderMapper.InConstructor.Field(Projectile::class, 9) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class int4 : OrderMapper.InConstructor.Field(Projectile::class, 10) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class int5 : OrderMapper.InConstructor.Field(Projectile::class, 12) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class int6 : OrderMapper.InConstructor.Field(Projectile::class, 1) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class int7 : OrderMapper.InConstructor.Field(Projectile::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }
}