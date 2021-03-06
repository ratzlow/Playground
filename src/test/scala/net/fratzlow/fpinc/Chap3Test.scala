package net.fratzlow.fpinc

import org.scalatest.{Matchers, FlatSpec}

/**
 * // TODO (FRa) : (FRa) : comment
 *
 * @author ratzlow@gmail.com
 * @since 2015-06-23
 */
class Chap3Test extends FlatSpec with Matchers {

    "tail" should "return all elements except the head" in {
        def assertTail[R] (f: () => R) : Unit = {
            intercept[UnsupportedOperationException] {
                f.apply()
            }
        }

        val l = List(1,2,3,4,5)
        assert ( l.tail === Chap3.tail(l) )

        assertTail( () => Chap3.tail(Nil) )
        assertTail( () => Nil.tail )
    }

    "setHead" should "replace first element of a list" in {
        assert( List(5,2,3) == Chap3.setHead(List(1,2,3), 5) )
        assert( List(5) == Chap3.setHead(List(1), 5) )
        intercept[UnsupportedOperationException] {
            assert( List(5) == Chap3.setHead(Nil, 5) )
        }
    }

    "drop" should "remove first n elements" in {
        assert( Nil == Chap3.drop(List(1,2,3), 5) )
        assert( List(3,4) == Chap3.drop(List(1,2,3,4), 2) )
        assert( Nil == Chap3.drop(Nil, 2) )
    }

    "dropWhile" should "remove elems as long as predicate is true" in {
        assert( List(6,7) == Chap3.dropWhile(List(4,5,6,7)) {_ < 6 } )
        assert( Nil == Chap3.dropWhile(List(6,7,8)) { _ < 10 } )
        assert( Nil == Chap3.dropWhile(Nil:List[Int]) { _ > 5} )
    }

    "init" should "return all but the last elem" in {
        assert( List(4,5,6) == Chap3.init(List(4,5,6,7) ) )
        assert( Nil == Chap3.init(List(4) ) )
        assert( Nil == Chap3.init(Nil ) )
    }
}
