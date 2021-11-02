package com.rugbyaholic.communityPG.websocket;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rugbyaholic.communityPG.auth.AuthenticatedUser;
import com.rugbyaholic.communityPG.auth.account.ProfileService;

@Controller
public class ChatController {

	@Autowired
	private ChatRoomService service;
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/conversationTo/chatRoom.html")
	public String conversationDo(Model model, @AuthenticationPrincipal AuthenticatedUser user) throws Exception {
		// サジェストされたユーザーを追加。
		model.addAttribute("profileEditForm", profileService.providePersonalInfo(user));
		model.addAttribute("conversationalUsers", service.getConversationalUsers(user)); 
		return "UserSugest.html";
	}

	// Ajaxの非同期通信で実装。最初の画面はHiddenで非表示にする。
	@GetMapping("/chatRoom.html")
	public String toEnterToChatRoom(@RequestParam(value = "id", required = true) Long id,
				 Model model, @AuthenticationPrincipal AuthenticatedUser user) throws Exception {
		model.addAttribute("messageHist", service.getMessageHist(user, id)); 
		model.addAttribute("idSet", new ChatMessage(user.getId(), id)); 
		return "chatRoom.html";
	}

	// 
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage( @Payload ChatMessage chatMessage) throws Exception {
    	service.registMessageInfo(chatMessage);
        return chatMessage;
        
    }
    
    @GetMapping("/websocket/DeleteMessage.do")
    public String toDeleterMessage(
    			@RequestParam(value = "avf", required = true) Timestamp sentAvf,
    			Model model, @AuthenticationPrincipal AuthenticatedUser user) throws Exception {
    	/**
    	 * 	public String onEditPostRequested(@RequestParam("postText") String postText, @RequestParam("postImg") ImageFile postImg,
				@RequestParam("topicNo") String topicNo, @RequestParam("postNo") int postNo, Model model) {

    	 */
    	service.deleteMessageHist(user.getId(),sentAvf);
    	return "redirect:/chatRoom.html";
    }
    
}