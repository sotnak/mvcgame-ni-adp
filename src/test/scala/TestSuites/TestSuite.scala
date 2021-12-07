package cz.cvut.fit.niadp
package TestSuites

import org.scalatest.Suites

class TestSuite extends Suites{
  new IteratorTest().test()
  new VisitorTest().test()
}
