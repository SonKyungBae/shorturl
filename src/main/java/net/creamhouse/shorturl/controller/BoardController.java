package net.creamhouse.shorturl.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.creamhouse.shorturl.domain.BoardVO;
import net.creamhouse.shorturl.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(BoardVO board, Model model) {
		
		logger.info("register get...");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		
		service.regist(board);
		rttr.addFlashAttribute("msg", "sucess");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		model.addAttribute("list", service.listAll());
		logger.info("list all....");
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Integer bno, Model model) throws Exception {
		logger.info("bno=" + bno);
		model.addAttribute("boardVO", service.read(bno));
		
		return "/board/read";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(Integer bno, Model model) throws Exception {		
		model.addAttribute("boardVO",service.read(bno));
		
		return "/board/modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {		
		service.modify(board);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(Integer bno) throws Exception {
		service.remove(bno);
		
		return "redirect:/board/listAll";
	}
	
	
		
}
