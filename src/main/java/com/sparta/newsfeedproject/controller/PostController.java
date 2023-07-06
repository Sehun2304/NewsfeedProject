package com.sparta.newsfeedproject.controller;

import com.sparta.newsfeedproject.dto.LikeRequestDto;
import com.sparta.newsfeedproject.dto.PostDto;
import com.sparta.newsfeedproject.service.LikeService;
import com.sparta.newsfeedproject.service.PostService;
import com.sparta.newsfeedproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final LikeService likeService;
    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute PostDto postDto){
        postService.save(postDto);
        return "index";
    }

    @GetMapping("/")
    public String findAll(Model model){
        List<PostDto> postDtoList = postService.findAll();
        model.addAttribute("postList",postDtoList);
        return "List";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        postService.updateHits(id);
        PostDto postDto = postService.findById(id);
        model.addAttribute("post",postDto);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model){
        PostDto postDto = postService.findById(id);
        model.addAttribute("postUpdate",postDto);
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute PostDto postDto, Model model){
        PostDto post = postService.update(postDto);
        model.addAttribute("post",post);
        return "detail";

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        postService.delete(id);
        return "redirect:/post/";
    }

    @PostMapping("/like")
    public String like(@RequestBody LikeRequestDto likeRequestDto) {
        likeService.likeBoard(likeRequestDto);
        return "redirect:/post/";
    }

}
