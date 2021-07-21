package com.steamtechs.core.data

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

internal class ValveInfoTest {


    //Create Blank Instance
    @Test
    @DisplayName("Create instance of ValveInfo.")
    fun `Create instance of ValveInfo`() {
        assertInstanceOf(ValveInfo::class.java,ValveInfo())
    }

    //Extends ComponentInfo
    @Test
    @DisplayName("Instances of ValveInfo can be called as ComponentInfo.")
    fun `Instances of ValveInfo can be called as ComponentInfo`() {
        assertInstanceOf(ComponentInfo::class.java, ValveInfo())
    }

    //With created instance:
    @Nested
    @DisplayName("Given instance of ValveInfo, ")
    inner class GivenValveInfoInstance {

        private lateinit var testValveInfo: ValveInfo

        @BeforeEach
        fun `Given instance of ValveInfo`(){
            testValveInfo = ValveInfo()
        }

        //Show getters/setters on empty instance

        //Manufacturer Attr
        @Test
        @DisplayName("get Manufacturer on empty instance.")
        fun `get Manufacturer on empty instance`() {
            assertEquals(null,testValveInfo.manufacturer)
        }

        @Test
        @DisplayName("set Manufacturer with only invalid chars.")
        fun `set Manufacturer with only invalid chars`() {

            assertThrows<Exception>{testValveInfo.manufacturer = """$$\\"""}
        }

        @Test
        @DisplayName("set Manufacturer attr fails with empty string.")
        fun `set Manufacturer attr fails with empty string`() {
            assertThrows<Exception> { testValveInfo.manufacturer = "" }
        }

        @Test
        @DisplayName("set Manufacturer attr filters unwanted chars.")
        fun `set Manufacturer attr works for valid strings`() {
            testValveInfo.manufacturer = """valid string here.!@#$\{}"""
            assertEquals("valid string here.!@#", testValveInfo.manufacturer)
        }

        //Supplier Attr.
        @Test
        @DisplayName("get Supplier on empty instance.")
        fun `get Supplier on empty instance`() {
            assertEquals(null, testValveInfo.supplier)
        }

        @Test
        @DisplayName("set Supplier with only invalid chars.")
        fun `set Supplier with only invalid chars`() {
            assertThrows<Exception>{testValveInfo.supplier = """{}\"""}
        }

        @Test
        @DisplayName("set Supplier attr fails with empty string.")
        fun `set Supplier attr fails with empty string`() {
            assertThrows<Exception> { testValveInfo.supplier = "" }
        }

        @Test
        @DisplayName("set Supplier attr filters unwanted chars.")
        fun `set Supplier attr filters unwanted chars`() {
            testValveInfo.supplier = """valid string here.!@#$\{}"""
            assertEquals("valid string here.!@#", testValveInfo.supplier)
        }

        //PartNumber
        @Test
        @DisplayName("get PartNumber on empty instance.")
        fun `get PartNumber on empty instance`() {
            assertEquals(null, testValveInfo.partNumber)
        }

        @Test
        @DisplayName("set PartNumber with only invalid chars.")
        fun `set PartNumber with only invalid chars`() {
            assertThrows<Exception>{testValveInfo.partNumber = """{\\$\$\{{"""}
        }

        @Test
        @DisplayName("set PartNumber attr fails with empty string.")
        fun `set PartNumber attr fails with empty string`() {
            assertThrows<Exception> { testValveInfo.partNumber = "" }
        }

        @Test
        @DisplayName("set PartNumber attr filters unwanted chars.")
        fun `set PartNumber attr filters unwanted chars`() {
            testValveInfo.partNumber = """valid string here.!@#$\{}"""
            assertEquals("valid string here.!@#", testValveInfo.partNumber)
        }

        //Populate instance
        @Nested
        @DisplayName("given ValveInfo populated with Manufacturer, Supplier, and PartNumber, ")
        inner class PopulatedValveInfo{

            @BeforeEach
            fun `Populate ValveInfo with Manufacturer, Supplier, and PartNumber`(){
                testValveInfo.manufacturer = "The Test Manufacturer!"
                testValveInfo.supplier = "Supplies the Best's Stuffs?"
                testValveInfo.partNumber = " a-23f9-##2B//"
            }

            //Show getters on populated instance
            @Test
            @DisplayName("get Manufacturer.")
            fun `get Manufacturer`() {
                assertEquals("The Test Manufacturer!", testValveInfo.manufacturer)
            }

            @Test
            @DisplayName("get Suppler.")
            fun `get Suppler`() {
                assertEquals("Supplies the Best's Stuffs?", testValveInfo.supplier)
            }

            @Test
            @DisplayName("get PartNumber.")
            fun `get PartNumber`() {
                assertEquals(" a-23f9-##2B//", testValveInfo.partNumber)
            }
        }
    }
}