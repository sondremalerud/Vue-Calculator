import MyCalculator from "/src/components/MyCalculator.vue";
import { mount } from "@vue/test-utils";
import { describe, test, expect } from "vitest";


describe("MyCalculator", () => {
    test("Renders properly", () => {
      const wrapper = mount(MyCalculator);
      expect(wrapper.text()).toContain("0CANSDEL÷789×456-123+ 0 .=");
    });

    test("Calculator display shows 0 on mount", () => {
      const wrapper = mount(MyCalculator);
      expect(wrapper.find("#display").text()).toBe("0");
    });

    test('addDigit() is called on button click', () => {
        const wrapper = mount(MyCalculator)
        const confirmSpy = vi.spyOn(wrapper.vm, 'addDigit')
        wrapper.find("#btn-1").trigger('click')
        expect(confirmSpy).toHaveBeenCalled()
    })

    test('Log updates correctly', () => {
        const wrapper = mount(MyCalculator)
        wrapper.find("#btn-1").trigger('click')
        wrapper.find("#btn-plus").trigger('click')
        wrapper.find("#btn-1").trigger('click')
        wrapper.find("#btn-evaluate").trigger('click')

        expect(wrapper.vm.logItems.length).toBe(1)
    })

});
